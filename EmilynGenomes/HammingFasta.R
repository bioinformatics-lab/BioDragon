#!/usr/bin/env Rscript

cat("HammingFasta v1.0",sep="\n")
cat("",sep="\n")
cat("Author: João Perdigão",sep="\n")
cat("",sep="\n")
cat("Usage: HammingFasta.R [FASTA alignment file]",sep="\n")
cat("",sep="\n")
cat("",sep="\n")


require(ape)
require(seqinr)
#require(phangorn)
#require(qgraph)

args = commandArgs(trailingOnly=TRUE)


if (length(args)==0) {
  stop("ERROR: This script requires a multifasta alignment file...", call.=FALSE)
} else if (length(args)==1) {
  # default output file
  args[2] = "out.txt"  ##Include standard output file
}


seq<-read.dna(args[1],format = "fasta")

#seq2<-as.phyDat(seq)



dists<-dist.dna(seq,model="N",as.matrix = F)

#dists4<-dist.hamming(seq2,ratio=F) # change to ratio to F to see the actual SNP difference

#dists_hamming<-as.data.frame(as.matrix(dists4))
dists_matrix<-as.matrix(dists)

colnames(dists_matrix)[1]<-paste(c(";"),colnames(dists_matrix)[1],sep="")
write.table(dists_matrix,"dists_hamming.csv",row.names=T,col.names=T,sep=";",quote = F)

print(dists)
cat("",sep="\n")
cat("Output Matrix File: dists_hamming.csv",sep="\n")


