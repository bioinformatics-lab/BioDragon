#!/usr/bin/env Rscript

cat("SNPtable_filter_Mtb v1.0",sep="\n")
cat("",sep="\n")
cat("Author: João Perdigão",sep="\n")
cat("",sep="\n")
cat("Usage: SNPtable_filter_Mtb.R [snippy-core SNP tab file]",sep="\n")
cat("",sep="\n")

require(ape)
require(seqinr)
#require(phangorn)

args = commandArgs(trailingOnly=TRUE)

if (length(args)==0) {
  stop("ERROR: This script requires a SNP table file from Snippy...", call.=FALSE)
} else if (length(args)==1) {
  # default output file
  args[2] = "out.txt"  ##Include standard output file
}

cat("Reading M. tuberculosis library files...",sep="\n")
cat("",sep="\n")

ppe_positions<-read.csv("~/library_files/PE_PPE_positions.txt",sep="\t",header=F)
database_uniq<-read.table("~/library_files/kmer.50.Reference.pre.txt",header=F,sep=" ")

cat("Reading M. tuberculosis library files...OK!",sep="\n")
cat("",sep="\n")

names(database_uniq)<-c("POS","V2")
pos_rem<-database_uniq[database_uniq$V2 < 49,]


snp_table_file<-args[1]
snp_table<-read.csv(args[1],sep="\t",header=)
snp_table<-subset(snp_table, select=-c(CHR,LOCUS_TAG,GENE,PRODUCT,EFFECT))

snp_table1<-snp_table[!snp_table$POS %in% ppe_positions$V1,]
cat("PE/PPE Positions removed...",sep="\n")
cat("",sep="\n")
snp_table2<-snp_table1[!snp_table1$POS %in% pos_rem$POS,]
cat("Positions with mapping quality below k-mer 49/50 removed...",sep="\n")
cat("",sep="\n")

cat("Converting to multifasta format...",sep="\n")
cat("",sep="\n")

snp_table3<-snp_table2[,-1]
sequence<-t(sapply(strsplit(as.character(snp_table3[,1]),""),tolower))
row.names(sequence)<-names(snp_table3[1])
alignment<-as.DNAbin(sequence)


for (i in 2:length((names(snp_table3)))) {
  
  
  sequence2<-t(sapply(strsplit(as.character(snp_table3[,i]),""),tolower))        
  #row.names(sequence2)<-names(snp_table[i])
  
  alignment2<-as.DNAbin(sequence2)
  
  alignment<-rbind(alignment,alignment2)
  
  
}

row.names(alignment)<-names(snp_table3)
row.names(alignment)[1]<-c("H37Rv") # adjust reference name

cat("Conversion to multifasta format... OK!",sep="\n")
cat("",sep="\n")
write.dna(alignment, "coreSNP_alignment_filtered.fas", format = "fasta",colsep = "")

cat("Output FASTA file: coreSNP_alignment_filtered.fas",sep="\n")
