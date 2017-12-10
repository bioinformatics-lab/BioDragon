
centos-a3_double_genome_single_script@ import $file.analysis 
Compiling /media/sf_Genomes/a3_double_genome_single_script/analysis.sc
import $file.$       

centos-a3_double_genome_single_script@ analysis.analyse_all_genomes(List("G04870")) 


>>>>> copy_reference_genome <<<<<




 ~~~~~~~~~~~~~~~~~~~~~ 

working on the G04870 files



>>>>       R1      <<<<


cat /media/sf_Genomes/a3_double_genome_single_script/BSSE_QGF_40815_C7JREANXX_6_D9_G04870_LRu_261015_GCTACGCT_AGAGTAGA_S68_L006_R1_001.fastq /media/sf_Genomes/a3_double_genome_single_script/BSSE_QGF_40815_C7JREANXX_7_D9_G04870_LRu_261015_GCTACGCT_AGAGTAGA_S68_L007_R1_001.fastq /media/sf_Genomes/a3_double_genome_single_script/BSSE_QGF_40815_C898AANXX_3_D9_G04870_LRu_261015_GCTACGCT_AGAGTAGA_S68_L003_R1_001.fastq  > /media/sf_Genomes/a3_double_genome_single_script/G04870_analysis/G04870_1.fastq




>>>>       R2      <<<<


cat /media/sf_Genomes/a3_double_genome_single_script/BSSE_QGF_40815_C7JREANXX_6_D9_G04870_LRu_261015_GCTACGCT_AGAGTAGA_S68_L006_R2_001.fastq /media/sf_Genomes/a3_double_genome_single_script/BSSE_QGF_40815_C7JREANXX_7_D9_G04870_LRu_261015_GCTACGCT_AGAGTAGA_S68_L007_R2_001.fastq /media/sf_Genomes/a3_double_genome_single_script/BSSE_QGF_40815_C898AANXX_3_D9_G04870_LRu_261015_GCTACGCT_AGAGTAGA_S68_L003_R2_001.fastq  > /media/sf_Genomes/a3_double_genome_single_script/G04870_analysis/G04870_2.fastq



@@@@@@@@@@@@@@@@@@@@@@@@


All Done!


>>>>> merge_and_rename <<<<<




>>>>> move_into_genome_folder <<<<<


java -jar /opt/Trimmomatic-0.36/trimmomatic-0.36.jar PE -phred33 G04870_1.fastq G04870_2.fastq G04870_1_trimmed_paired.fastq G04870_1_trimmed_unpaired.fastq G04870_2_trimmed_paired.fastq G04870_2_trimmed_unpaired.fastq LEADING:3 TRAILING:3 SLIDINGWINDOW:4:20 MINLEN:36
TrimmomaticPE: Started with arguments:
 -phred33 G04870_1.fastq G04870_2.fastq G04870_1_trimmed_paired.fastq G04870_1_trimmed_unpaired.fastq G04870_2_trimmed_paired.fastq G04870_2_trimmed_unpaired.fastq LEADING:3 TRAILING:3 SLIDINGWINDOW:4:20 MINLEN:36
Multiple cores found: Using 2 threads
Input Read Pairs: 4672440 Both Surviving: 3965294 (84.87%) Forward Only Surviving: 338721 (7.25%) Reverse Only Surviving: 76531 (1.64%) Dropped: 291894 (6.25%)
TrimmomaticPE: Completed successfully





>>>>> trimmomatic <<<<<

bwa index NC000962_3.fasta
[bwa_index] Pack FASTA... 0.05 sec
[bwa_index] Construct BWT for the packed sequence...
[bwa_index] 2.07 seconds elapse.
[bwa_index] Update BWT... 0.05 sec
[bwa_index] Pack forward-only FASTA... 0.04 sec
[bwa_index] Construct SA from BWT and Occ... 1.29 sec
[main] Version: 0.7.12-r1039
[main] CMD: bwa index NC000962_3.fasta
[main] Real time: 3.803 sec; CPU: 3.510 sec


>>>>> bwa_index_reference_genome <<<<<




>>>>> map_and_generate_sam_file <<<<<


bwa mem -R "@RG\tID:G04870\tSM:G04870\tPL:Illumina" -M NC000962_3.fasta G04870_1_trimmed_paired.fastq G04870_2_trimmed_paired.fastq > G04870.sam
[M::bwa_idx_load_from_disk] read 0 ALT contigs
[M::process] read 100492 sequences (10000152 bp)...
[M::process] read 100472 sequences (10000111 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (137, 48303, 24, 131)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (127, 191, 305)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 661)
[M::mem_pestat] mean and std.dev: (212.11, 131.47)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 839)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (136, 219, 345)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 763)
[M::mem_pestat] mean and std.dev: (252.69, 151.06)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 972)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (135, 425, 2397)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 6921)
[M::mem_pestat] mean and std.dev: (1250.96, 1479.00)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 9183)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (100, 181, 296)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 688)
[M::mem_pestat] mean and std.dev: (207.61, 134.57)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 884)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100492 reads in 8.177 CPU sec, 7.958 real sec
[M::process] read 100782 sequences (10000110 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (125, 48307, 12, 119)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (124, 184, 327)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 733)
[M::mem_pestat] mean and std.dev: (224.41, 140.37)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 936)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (133, 216, 336)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 742)
[M::mem_pestat] mean and std.dev: (246.66, 145.99)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 945)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (830, 2424, 4295)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 11225)
[M::mem_pestat] mean and std.dev: (2190.25, 1592.06)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 14690)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (100, 170, 309)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 727)
[M::mem_pestat] mean and std.dev: (209.37, 146.48)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 936)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100472 reads in 6.085 CPU sec, 5.512 real sec
[M::process] read 100370 sequences (10000112 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (107, 48387, 16, 122)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (100, 182, 288)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 664)
[M::mem_pestat] mean and std.dev: (206.95, 142.10)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 852)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (134, 215, 336)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 740)
[M::mem_pestat] mean and std.dev: (246.94, 146.06)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 942)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (319, 1568, 4869)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 13969)
[M::mem_pestat] mean and std.dev: (2226.62, 2150.27)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 18519)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (93, 181, 322)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 780)
[M::mem_pestat] mean and std.dev: (216.43, 148.41)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1009)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100782 reads in 6.262 CPU sec, 5.728 real sec
[M::process] read 100292 sequences (10000066 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (154, 48229, 13, 114)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (97, 188, 294)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 688)
[M::mem_pestat] mean and std.dev: (203.56, 130.34)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 885)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (138, 223, 346)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 762)
[M::mem_pestat] mean and std.dev: (254.40, 150.22)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 970)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (718, 1536, 4614)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 12406)
[M::mem_pestat] mean and std.dev: (2550.77, 2454.54)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 16302)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (106, 165, 250)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 538)
[M::mem_pestat] mean and std.dev: (190.93, 116.28)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 682)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100370 reads in 5.506 CPU sec, 4.991 real sec
[M::process] read 100308 sequences (10000183 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (123, 48082, 14, 148)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (127, 219, 320)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 706)
[M::mem_pestat] mean and std.dev: (226.34, 137.19)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 899)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (140, 224, 351)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 773)
[M::mem_pestat] mean and std.dev: (257.54, 152.50)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 984)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (73, 370, 1480)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 4294)
[M::mem_pestat] mean and std.dev: (757.31, 838.89)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 5701)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (93, 151, 283)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 663)
[M::mem_pestat] mean and std.dev: (190.73, 134.40)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 853)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100292 reads in 5.373 CPU sec, 4.930 real sec
[M::process] read 100534 sequences (10000189 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (130, 48140, 20, 156)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (108, 174, 280)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 624)
[M::mem_pestat] mean and std.dev: (199.36, 132.15)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 796)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (139, 225, 352)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 778)
[M::mem_pestat] mean and std.dev: (258.38, 153.43)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 991)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (793, 1642, 3663)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 9403)
[M::mem_pestat] mean and std.dev: (2187.85, 1656.69)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 12273)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (103, 204, 336)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 802)
[M::mem_pestat] mean and std.dev: (231.07, 160.03)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1035)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100308 reads in 5.816 CPU sec, 5.372 real sec
[M::process] read 100748 sequences (10000100 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (143, 48238, 17, 114)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (115, 202, 322)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 736)
[M::mem_pestat] mean and std.dev: (222.72, 154.68)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 943)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (137, 222, 350)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 776)
[M::mem_pestat] mean and std.dev: (256.71, 154.74)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 989)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (525, 819, 3605)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 9765)
[M::mem_pestat] mean and std.dev: (1811.47, 1904.45)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 12845)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (106, 190, 280)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 628)
[M::mem_pestat] mean and std.dev: (205.39, 128.17)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 802)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100534 reads in 5.214 CPU sec, 4.698 real sec
[M::process] read 100664 sequences (10000035 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (108, 48347, 11, 126)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (118, 201, 335)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 769)
[M::mem_pestat] mean and std.dev: (233.92, 153.89)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 986)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (136, 220, 347)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 769)
[M::mem_pestat] mean and std.dev: (254.25, 153.33)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 980)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (436, 852, 2438)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 6442)
[M::mem_pestat] mean and std.dev: (1399.91, 1372.27)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 8444)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (108, 199, 317)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 735)
[M::mem_pestat] mean and std.dev: (227.34, 150.47)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 944)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100748 reads in 5.648 CPU sec, 5.203 real sec
[M::process] read 100788 sequences (10000164 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (173, 48336, 16, 123)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (99, 181, 353)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 861)
[M::mem_pestat] mean and std.dev: (231.86, 174.63)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1115)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (136, 218, 343)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 757)
[M::mem_pestat] mean and std.dev: (251.68, 150.57)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 964)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (282, 1128, 3379)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 9573)
[M::mem_pestat] mean and std.dev: (1935.31, 2185.81)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 12670)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (97, 189, 359)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 883)
[M::mem_pestat] mean and std.dev: (240.17, 173.92)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1145)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100664 reads in 5.652 CPU sec, 5.184 real sec
[M::process] read 100358 sequences (10000153 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (141, 48393, 19, 122)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (98, 173, 285)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 659)
[M::mem_pestat] mean and std.dev: (196.83, 129.19)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 846)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (137, 221, 346)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 764)
[M::mem_pestat] mean and std.dev: (253.27, 150.97)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 973)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (147, 448, 1962)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 5592)
[M::mem_pestat] mean and std.dev: (1145.89, 1298.25)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 7407)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (93, 167, 299)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 711)
[M::mem_pestat] mean and std.dev: (202.38, 142.06)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 917)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100788 reads in 5.119 CPU sec, 4.630 real sec
[M::process] read 100458 sequences (10000083 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (152, 48098, 16, 141)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (104, 190, 306)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 710)
[M::mem_pestat] mean and std.dev: (211.89, 138.90)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 912)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (140, 227, 354)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 782)
[M::mem_pestat] mean and std.dev: (259.54, 154.26)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 996)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (318, 1134, 3366)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 9462)
[M::mem_pestat] mean and std.dev: (1602.94, 1632.79)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 12510)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (90, 182, 325)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 795)
[M::mem_pestat] mean and std.dev: (214.36, 152.70)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1030)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100358 reads in 5.629 CPU sec, 5.187 real sec
[M::process] read 100460 sequences (10000037 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (147, 48348, 18, 105)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (94, 173, 279)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 649)
[M::mem_pestat] mean and std.dev: (200.03, 136.05)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 834)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (139, 226, 356)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 790)
[M::mem_pestat] mean and std.dev: (260.40, 156.30)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1007)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (152, 604, 2783)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 8045)
[M::mem_pestat] mean and std.dev: (1716.50, 2198.64)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 10676)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (106, 186, 297)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 679)
[M::mem_pestat] mean and std.dev: (210.28, 137.24)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 870)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100458 reads in 5.068 CPU sec, 4.710 real sec
[M::process] read 100448 sequences (10000162 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (156, 48240, 14, 116)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (109, 191, 293)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 661)
[M::mem_pestat] mean and std.dev: (207.76, 132.97)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 845)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (139, 225, 355)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 787)
[M::mem_pestat] mean and std.dev: (259.74, 155.82)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1003)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (842, 1905, 2598)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 6110)
[M::mem_pestat] mean and std.dev: (2071.36, 1607.76)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 7866)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (83, 143, 290)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 704)
[M::mem_pestat] mean and std.dev: (189.57, 138.02)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 911)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100460 reads in 4.795 CPU sec, 4.436 real sec
[M::process] read 100654 sequences (10000128 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (144, 48276, 16, 150)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (116, 209, 324)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 740)
[M::mem_pestat] mean and std.dev: (235.16, 151.53)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 948)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (136, 222, 350)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 778)
[M::mem_pestat] mean and std.dev: (256.45, 155.48)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 992)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (297, 587, 1760)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 4686)
[M::mem_pestat] mean and std.dev: (1068.62, 1192.76)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 6149)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (102, 183, 308)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 720)
[M::mem_pestat] mean and std.dev: (210.29, 147.27)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 926)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100448 reads in 4.797 CPU sec, 4.456 real sec
[M::process] read 100736 sequences (10000015 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (126, 48356, 19, 135)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (85, 158, 284)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 682)
[M::mem_pestat] mean and std.dev: (183.04, 130.42)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 881)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (137, 222, 351)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 779)
[M::mem_pestat] mean and std.dev: (256.53, 155.70)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 993)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (369, 469, 2542)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 6888)
[M::mem_pestat] mean and std.dev: (1099.33, 1268.09)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 9061)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (88, 165, 270)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 634)
[M::mem_pestat] mean and std.dev: (189.08, 127.38)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 816)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100654 reads in 4.815 CPU sec, 4.473 real sec
[M::process] read 100370 sequences (10000017 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (150, 48379, 18, 135)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (99, 189, 320)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 762)
[M::mem_pestat] mean and std.dev: (220.88, 154.18)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 983)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (135, 220, 349)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 777)
[M::mem_pestat] mean and std.dev: (254.28, 154.07)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 991)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (763, 1590, 3162)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 7960)
[M::mem_pestat] mean and std.dev: (1948.72, 1594.68)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 10359)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (106, 183, 285)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 643)
[M::mem_pestat] mean and std.dev: (207.20, 132.10)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 822)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100736 reads in 4.795 CPU sec, 4.474 real sec
[M::process] read 100270 sequences (10000131 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (144, 48072, 22, 137)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (119, 212, 323)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 731)
[M::mem_pestat] mean and std.dev: (230.16, 158.04)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 935)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (138, 222, 348)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 768)
[M::mem_pestat] mean and std.dev: (255.07, 151.82)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 978)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (356, 2633, 4499)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 12785)
[M::mem_pestat] mean and std.dev: (2308.14, 1898.31)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 16928)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (101, 191, 314)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 740)
[M::mem_pestat] mean and std.dev: (211.66, 144.28)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 953)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100370 reads in 4.841 CPU sec, 4.490 real sec
[M::process] read 100290 sequences (10000188 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (162, 48137, 18, 153)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (97, 205, 345)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 841)
[M::mem_pestat] mean and std.dev: (234.66, 171.55)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1089)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (139, 225, 354)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 784)
[M::mem_pestat] mean and std.dev: (259.34, 155.35)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 999)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (235, 1398, 2046)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 5668)
[M::mem_pestat] mean and std.dev: (1265.22, 1150.29)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 7479)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (85, 168, 326)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 808)
[M::mem_pestat] mean and std.dev: (213.83, 168.21)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1049)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100270 reads in 4.533 CPU sec, 4.145 real sec
[M::process] read 100418 sequences (10000183 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (143, 48161, 15, 133)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (129, 210, 373)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 861)
[M::mem_pestat] mean and std.dev: (240.21, 157.82)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1105)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (139, 226, 354)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 784)
[M::mem_pestat] mean and std.dev: (259.43, 154.96)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 999)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (281, 1114, 3595)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 10223)
[M::mem_pestat] mean and std.dev: (1872.07, 1713.02)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 13537)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (102, 191, 330)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 786)
[M::mem_pestat] mean and std.dev: (225.21, 161.02)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1014)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100290 reads in 4.799 CPU sec, 4.447 real sec
[M::process] read 100530 sequences (10000185 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (136, 48207, 17, 127)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (107, 190, 354)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 848)
[M::mem_pestat] mean and std.dev: (228.13, 152.16)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1095)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (137, 222, 347)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 767)
[M::mem_pestat] mean and std.dev: (254.70, 152.36)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 977)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (204, 1193, 3133)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 8991)
[M::mem_pestat] mean and std.dev: (1539.00, 1486.86)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 11920)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (107, 184, 325)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 761)
[M::mem_pestat] mean and std.dev: (222.70, 147.25)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 979)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100418 reads in 4.526 CPU sec, 4.142 real sec
[M::process] read 100658 sequences (10000088 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (147, 48225, 24, 120)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (75, 168, 278)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 684)
[M::mem_pestat] mean and std.dev: (196.43, 148.16)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 887)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (136, 220, 343)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 757)
[M::mem_pestat] mean and std.dev: (251.84, 149.85)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 964)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (317, 1589, 4562)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 13052)
[M::mem_pestat] mean and std.dev: (2000.25, 1850.14)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 17297)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (91, 172, 309)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 745)
[M::mem_pestat] mean and std.dev: (208.71, 148.79)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 963)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100530 reads in 4.805 CPU sec, 4.456 real sec
[M::process] read 100716 sequences (10000200 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (128, 48332, 11, 120)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (102, 178, 337)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 807)
[M::mem_pestat] mean and std.dev: (227.30, 169.37)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1042)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (133, 216, 341)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 757)
[M::mem_pestat] mean and std.dev: (248.85, 149.16)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 965)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (105, 342, 1731)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 4983)
[M::mem_pestat] mean and std.dev: (1052.73, 1336.70)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 6609)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (98, 180, 304)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 716)
[M::mem_pestat] mean and std.dev: (212.00, 137.84)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 922)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100658 reads in 4.613 CPU sec, 4.150 real sec
[M::process] read 100234 sequences (10000133 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (131, 48364, 17, 115)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (80, 138, 266)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 638)
[M::mem_pestat] mean and std.dev: (178.62, 125.16)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 824)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (134, 217, 337)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 743)
[M::mem_pestat] mean and std.dev: (247.58, 146.63)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 946)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (351, 1504, 2696)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 7386)
[M::mem_pestat] mean and std.dev: (1879.94, 1603.46)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 9731)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (111, 202, 311)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 711)
[M::mem_pestat] mean and std.dev: (209.68, 121.66)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 911)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100716 reads in 4.695 CPU sec, 4.284 real sec
[M::process] read 100278 sequences (10000117 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (166, 48048, 16, 138)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (103, 199, 312)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 730)
[M::mem_pestat] mean and std.dev: (211.85, 144.36)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 939)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (138, 221, 344)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 756)
[M::mem_pestat] mean and std.dev: (252.50, 148.48)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 962)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (324, 1379, 3810)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 10782)
[M::mem_pestat] mean and std.dev: (1985.25, 2003.59)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 14268)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (96, 174, 274)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 630)
[M::mem_pestat] mean and std.dev: (194.07, 125.37)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 808)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100234 reads in 4.484 CPU sec, 4.091 real sec
[M::process] read 100412 sequences (10000093 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (135, 48155, 19, 131)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (116, 206, 308)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 692)
[M::mem_pestat] mean and std.dev: (222.80, 133.91)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 884)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (139, 223, 346)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 760)
[M::mem_pestat] mean and std.dev: (254.29, 149.92)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 967)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (111, 277, 1915)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 5523)
[M::mem_pestat] mean and std.dev: (1084.61, 1419.34)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 7327)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (106, 173, 273)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 607)
[M::mem_pestat] mean and std.dev: (199.70, 129.13)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 774)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100278 reads in 4.750 CPU sec, 4.399 real sec
[M::process] read 100538 sequences (10000167 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (158, 48141, 18, 128)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (109, 189, 314)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 724)
[M::mem_pestat] mean and std.dev: (225.80, 145.82)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 929)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (137, 221, 348)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 770)
[M::mem_pestat] mean and std.dev: (254.70, 152.63)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 981)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (200, 2546, 3905)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 11315)
[M::mem_pestat] mean and std.dev: (2098.94, 1771.73)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 15020)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (115, 179, 298)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 664)
[M::mem_pestat] mean and std.dev: (206.07, 126.99)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 847)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100412 reads in 4.444 CPU sec, 4.073 real sec
[M::process] read 100654 sequences (10000147 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (144, 48274, 25, 121)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (116, 186, 367)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 869)
[M::mem_pestat] mean and std.dev: (245.81, 175.91)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1120)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (136, 221, 347)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 769)
[M::mem_pestat] mean and std.dev: (254.13, 152.64)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 980)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (477, 1623, 4558)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 12720)
[M::mem_pestat] mean and std.dev: (2148.48, 1867.45)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 16801)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (89, 194, 334)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 824)
[M::mem_pestat] mean and std.dev: (216.47, 153.71)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1069)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100538 reads in 4.854 CPU sec, 4.495 real sec
[M::process] read 101036 sequences (10000044 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (132, 48362, 13, 115)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (109, 185, 303)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 691)
[M::mem_pestat] mean and std.dev: (208.74, 127.10)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 885)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (136, 220, 346)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 766)
[M::mem_pestat] mean and std.dev: (253.30, 152.07)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 976)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (359, 919, 4665)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 13277)
[M::mem_pestat] mean and std.dev: (2053.69, 1980.98)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 17583)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (109, 188, 323)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 751)
[M::mem_pestat] mean and std.dev: (230.24, 158.85)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 965)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100654 reads in 4.549 CPU sec, 4.157 real sec
[M::process] read 100244 sequences (10000018 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (119, 48622, 7, 127)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (100, 156, 310)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 730)
[M::mem_pestat] mean and std.dev: (198.30, 140.51)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 940)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (134, 216, 342)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 758)
[M::mem_pestat] mean and std.dev: (250.24, 150.94)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 966)
[M::mem_pestat] skip orientation RF as there are not enough pairs
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (116, 199, 345)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 803)
[M::mem_pestat] mean and std.dev: (227.92, 144.04)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1032)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 101036 reads in 4.854 CPU sec, 4.525 real sec
[M::process] read 100238 sequences (10000137 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (156, 48121, 17, 111)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (114, 181, 300)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 672)
[M::mem_pestat] mean and std.dev: (212.00, 137.14)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 858)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (141, 228, 355)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 783)
[M::mem_pestat] mean and std.dev: (260.20, 154.16)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 997)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (223, 699, 2526)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 7132)
[M::mem_pestat] mean and std.dev: (1405.65, 1558.13)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 9435)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (130, 203, 331)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 733)
[M::mem_pestat] mean and std.dev: (221.59, 135.22)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 934)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100244 reads in 4.905 CPU sec, 4.526 real sec
[M::process] read 100378 sequences (10000087 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (122, 48127, 14, 125)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (103, 210, 344)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 826)
[M::mem_pestat] mean and std.dev: (246.23, 172.03)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1067)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (140, 227, 355)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 785)
[M::mem_pestat] mean and std.dev: (260.73, 155.56)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1000)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (632, 1536, 4557)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 12407)
[M::mem_pestat] mean and std.dev: (2061.57, 1750.41)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 16332)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (102, 190, 336)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 804)
[M::mem_pestat] mean and std.dev: (211.68, 144.44)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1038)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100238 reads in 4.497 CPU sec, 4.086 real sec
[M::process] read 100148 sequences (10000100 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (153, 48166, 18, 122)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (122, 201, 359)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 833)
[M::mem_pestat] mean and std.dev: (249.01, 175.44)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1070)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (139, 226, 356)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 790)
[M::mem_pestat] mean and std.dev: (261.12, 157.82)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1007)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (600, 998, 3600)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 9600)
[M::mem_pestat] mean and std.dev: (1887.33, 1705.82)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 12600)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (117, 220, 376)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 894)
[M::mem_pestat] mean and std.dev: (247.39, 166.59)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1153)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100378 reads in 4.532 CPU sec, 4.149 real sec
[M::process] read 100290 sequences (10000158 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (134, 48120, 15, 115)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (86, 153, 297)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 719)
[M::mem_pestat] mean and std.dev: (203.67, 149.41)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 930)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (138, 221, 343)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 753)
[M::mem_pestat] mean and std.dev: (252.40, 147.67)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 958)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (848, 1615, 4257)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 11075)
[M::mem_pestat] mean and std.dev: (2127.40, 1645.58)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 14484)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (110, 220, 324)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 752)
[M::mem_pestat] mean and std.dev: (227.86, 145.67)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 966)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100148 reads in 4.513 CPU sec, 4.101 real sec
[M::process] read 100380 sequences (10000157 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (149, 48129, 15, 132)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (116, 201, 310)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 698)
[M::mem_pestat] mean and std.dev: (220.44, 148.68)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 892)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (138, 224, 348)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 768)
[M::mem_pestat] mean and std.dev: (256.16, 152.23)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 978)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (702, 1907, 2607)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 6417)
[M::mem_pestat] mean and std.dev: (2071.27, 1691.00)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 8322)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (108, 193, 322)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 750)
[M::mem_pestat] mean and std.dev: (219.52, 146.00)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 964)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100290 reads in 4.452 CPU sec, 4.066 real sec
[M::process] read 100510 sequences (10000101 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (149, 48186, 17, 110)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (109, 181, 317)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 733)
[M::mem_pestat] mean and std.dev: (211.43, 137.95)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 941)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (137, 222, 349)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 773)
[M::mem_pestat] mean and std.dev: (255.66, 153.51)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 985)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (337, 803, 2783)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 7675)
[M::mem_pestat] mean and std.dev: (1416.24, 1380.26)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 10121)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (111, 212, 370)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 888)
[M::mem_pestat] mean and std.dev: (249.96, 165.76)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1147)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100380 reads in 4.672 CPU sec, 4.262 real sec
[M::process] read 100382 sequences (10000038 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (142, 48266, 18, 135)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (124, 222, 328)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 736)
[M::mem_pestat] mean and std.dev: (239.39, 141.96)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 940)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (138, 224, 352)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 780)
[M::mem_pestat] mean and std.dev: (258.20, 154.90)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 994)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (122, 605, 2301)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 6659)
[M::mem_pestat] mean and std.dev: (1205.06, 1485.52)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 8838)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (111, 182, 303)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 687)
[M::mem_pestat] mean and std.dev: (216.99, 144.33)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 879)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100510 reads in 4.532 CPU sec, 4.137 real sec
[M::process] read 100840 sequences (10000147 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (128, 48166, 9, 115)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (123, 206, 307)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 675)
[M::mem_pestat] mean and std.dev: (215.31, 129.42)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 859)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (135, 219, 342)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 756)
[M::mem_pestat] mean and std.dev: (250.84, 149.16)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 963)
[M::mem_pestat] skip orientation RF as there are not enough pairs
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (104, 179, 312)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 728)
[M::mem_pestat] mean and std.dev: (216.94, 154.85)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 936)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100382 reads in 4.517 CPU sec, 4.110 real sec
[M::process] read 100694 sequences (10000104 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (123, 48451, 17, 127)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (99, 173, 295)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 687)
[M::mem_pestat] mean and std.dev: (210.86, 150.12)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 883)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (135, 219, 344)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 762)
[M::mem_pestat] mean and std.dev: (252.38, 151.87)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 971)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (56, 477, 3459)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 10265)
[M::mem_pestat] mean and std.dev: (1331.71, 1562.50)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 13668)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (121, 167, 323)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 727)
[M::mem_pestat] mean and std.dev: (212.71, 134.97)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 929)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100840 reads in 4.479 CPU sec, 4.080 real sec
[M::process] read 100852 sequences (10000139 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (144, 48387, 7, 123)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (100, 167, 300)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 700)
[M::mem_pestat] mean and std.dev: (196.18, 141.01)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 900)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (134, 216, 337)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 743)
[M::mem_pestat] mean and std.dev: (247.49, 147.22)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 946)
[M::mem_pestat] skip orientation RF as there are not enough pairs
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (112, 197, 308)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 700)
[M::mem_pestat] mean and std.dev: (216.99, 144.38)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 896)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100694 reads in 4.586 CPU sec, 4.172 real sec
[M::process] read 101096 sequences (10000133 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (142, 48466, 14, 131)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (94, 172, 307)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 733)
[M::mem_pestat] mean and std.dev: (218.43, 160.92)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 946)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (133, 214, 335)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 739)
[M::mem_pestat] mean and std.dev: (246.09, 146.08)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 941)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (152, 282, 2925)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 8471)
[M::mem_pestat] mean and std.dev: (1491.79, 2042.89)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 11244)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (86, 158, 270)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 638)
[M::mem_pestat] mean and std.dev: (186.06, 125.61)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 822)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100852 reads in 4.740 CPU sec, 4.340 real sec
[M::process] read 101046 sequences (10000201 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (159, 48515, 11, 123)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (113, 176, 285)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 629)
[M::mem_pestat] mean and std.dev: (207.68, 138.46)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 801)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (132, 212, 332)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 732)
[M::mem_pestat] mean and std.dev: (243.30, 145.06)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 932)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (283, 586, 4521)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 12997)
[M::mem_pestat] mean and std.dev: (1756.91, 1941.11)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 17235)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (82, 181, 273)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 655)
[M::mem_pestat] mean and std.dev: (193.22, 140.69)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 846)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 101096 reads in 4.543 CPU sec, 4.138 real sec
[M::process] read 100526 sequences (10000008 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (121, 48538, 12, 120)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (113, 182, 312)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 710)
[M::mem_pestat] mean and std.dev: (223.91, 151.26)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 909)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (132, 213, 330)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 726)
[M::mem_pestat] mean and std.dev: (242.95, 143.47)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 924)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (520, 1278, 1829)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 4447)
[M::mem_pestat] mean and std.dev: (1229.45, 870.04)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 5756)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (103, 172, 295)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 679)
[M::mem_pestat] mean and std.dev: (198.56, 135.15)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 871)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 101046 reads in 4.545 CPU sec, 4.155 real sec
[M::process] read 100592 sequences (10000005 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (120, 48314, 17, 123)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (96, 193, 298)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 702)
[M::mem_pestat] mean and std.dev: (204.27, 130.39)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 904)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (135, 217, 336)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 738)
[M::mem_pestat] mean and std.dev: (247.47, 145.09)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 939)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (484, 1631, 4372)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 12148)
[M::mem_pestat] mean and std.dev: (1976.88, 1707.96)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 16036)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (85, 172, 295)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 715)
[M::mem_pestat] mean and std.dev: (194.15, 137.39)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 925)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100526 reads in 4.591 CPU sec, 4.185 real sec
[M::process] read 100570 sequences (10000059 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (143, 48235, 24, 113)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (115, 202, 324)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 742)
[M::mem_pestat] mean and std.dev: (234.90, 153.85)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 951)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (136, 218, 341)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 751)
[M::mem_pestat] mean and std.dev: (250.55, 148.04)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 956)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (390, 944, 4733)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 13419)
[M::mem_pestat] mean and std.dev: (1991.12, 2052.38)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 17762)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (86, 165, 296)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 716)
[M::mem_pestat] mean and std.dev: (184.50, 126.58)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 926)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100592 reads in 4.944 CPU sec, 4.603 real sec
[M::process] read 100766 sequences (10000199 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (130, 48282, 15, 140)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (108, 212, 321)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 747)
[M::mem_pestat] mean and std.dev: (229.14, 149.50)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 960)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (135, 218, 339)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 747)
[M::mem_pestat] mean and std.dev: (249.47, 148.49)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 951)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (586, 1462, 4449)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 12175)
[M::mem_pestat] mean and std.dev: (2055.20, 1982.74)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 16038)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (98, 165, 271)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 617)
[M::mem_pestat] mean and std.dev: (192.96, 128.23)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 790)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100570 reads in 5.065 CPU sec, 4.644 real sec
[M::process] read 100572 sequences (10000073 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (162, 48246, 25, 142)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (103, 188, 313)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 733)
[M::mem_pestat] mean and std.dev: (222.76, 152.39)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 943)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (140, 225, 352)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 776)
[M::mem_pestat] mean and std.dev: (258.05, 152.27)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 988)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (162, 1158, 3618)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 10530)
[M::mem_pestat] mean and std.dev: (1779.60, 1823.87)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 13986)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (90, 160, 295)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 705)
[M::mem_pestat] mean and std.dev: (204.96, 154.38)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 910)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100766 reads in 4.974 CPU sec, 4.627 real sec
[M::process] read 100718 sequences (10000092 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (123, 48256, 9, 148)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (100, 180, 297)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 691)
[M::mem_pestat] mean and std.dev: (212.02, 138.67)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 888)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (138, 222, 348)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 768)
[M::mem_pestat] mean and std.dev: (255.31, 152.03)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 978)
[M::mem_pestat] skip orientation RF as there are not enough pairs
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (92, 172, 278)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 650)
[M::mem_pestat] mean and std.dev: (198.38, 135.67)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 836)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100572 reads in 5.575 CPU sec, 5.198 real sec
[M::process] read 100642 sequences (10000159 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (140, 48354, 20, 128)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (108, 196, 290)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 654)
[M::mem_pestat] mean and std.dev: (212.92, 134.26)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 836)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (137, 221, 346)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 764)
[M::mem_pestat] mean and std.dev: (253.59, 150.79)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 973)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (524, 744, 2449)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 6299)
[M::mem_pestat] mean and std.dev: (1451.50, 1407.41)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 8224)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (87, 159, 318)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 780)
[M::mem_pestat] mean and std.dev: (213.02, 164.44)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1011)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100718 reads in 5.371 CPU sec, 5.047 real sec
[M::process] read 100678 sequences (10000174 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (129, 48265, 5, 130)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (79, 171, 310)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 772)
[M::mem_pestat] mean and std.dev: (217.16, 161.50)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1003)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (134, 217, 337)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 743)
[M::mem_pestat] mean and std.dev: (248.14, 146.45)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 946)
[M::mem_pestat] skip orientation RF as there are not enough pairs
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (108, 176, 273)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 603)
[M::mem_pestat] mean and std.dev: (191.14, 125.61)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 768)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100642 reads in 4.863 CPU sec, 4.516 real sec
[M::process] read 101136 sequences (10000061 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (150, 48342, 8, 121)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (103, 178, 311)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 727)
[M::mem_pestat] mean and std.dev: (206.45, 141.42)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 935)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (135, 218, 340)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 750)
[M::mem_pestat] mean and std.dev: (249.59, 148.52)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 955)
[M::mem_pestat] skip orientation RF as there are not enough pairs
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (102, 193, 304)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 708)
[M::mem_pestat] mean and std.dev: (212.41, 140.93)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 910)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100678 reads in 4.924 CPU sec, 4.561 real sec
[M::process] read 100718 sequences (10000042 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (145, 48548, 22, 123)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (100, 195, 294)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 682)
[M::mem_pestat] mean and std.dev: (214.91, 141.23)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 876)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (132, 210, 329)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 723)
[M::mem_pestat] mean and std.dev: (241.10, 142.32)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 920)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (317, 882, 2081)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 5609)
[M::mem_pestat] mean and std.dev: (1142.29, 1101.65)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 7373)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (96, 186, 315)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 753)
[M::mem_pestat] mean and std.dev: (211.97, 148.76)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 972)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 101136 reads in 4.792 CPU sec, 4.387 real sec
[M::process] read 100724 sequences (10000182 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (145, 48379, 11, 137)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (110, 222, 303)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 689)
[M::mem_pestat] mean and std.dev: (226.92, 144.55)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 882)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (137, 219, 339)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 743)
[M::mem_pestat] mean and std.dev: (249.95, 146.29)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 945)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (205, 684, 2442)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 6916)
[M::mem_pestat] mean and std.dev: (1397.82, 1656.88)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 9153)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (81, 156, 251)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 591)
[M::mem_pestat] mean and std.dev: (172.40, 115.76)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 761)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100718 reads in 4.796 CPU sec, 4.393 real sec
[M::process] read 100528 sequences (10000160 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (140, 48291, 14, 135)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (93, 174, 267)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 615)
[M::mem_pestat] mean and std.dev: (198.64, 141.63)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 789)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (134, 215, 335)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 737)
[M::mem_pestat] mean and std.dev: (246.62, 145.41)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 938)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (261, 1365, 2651)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 7431)
[M::mem_pestat] mean and std.dev: (1809.71, 1841.59)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 9821)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (103, 165, 267)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 595)
[M::mem_pestat] mean and std.dev: (191.84, 127.20)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 759)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100724 reads in 4.867 CPU sec, 4.452 real sec
[M::process] read 100588 sequences (10000028 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (152, 48206, 11, 129)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (100, 186, 312)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 736)
[M::mem_pestat] mean and std.dev: (204.72, 137.81)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 948)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (136, 220, 340)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 748)
[M::mem_pestat] mean and std.dev: (250.54, 147.69)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 952)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (401, 726, 1594)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 3980)
[M::mem_pestat] mean and std.dev: (1019.18, 904.31)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 5173)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (92, 181, 276)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 644)
[M::mem_pestat] mean and std.dev: (193.70, 138.03)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 828)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100528 reads in 4.658 CPU sec, 4.261 real sec
[M::process] read 100774 sequences (10000119 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (146, 48374, 13, 136)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (121, 191, 330)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 748)
[M::mem_pestat] mean and std.dev: (230.85, 152.25)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 957)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (136, 219, 342)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 754)
[M::mem_pestat] mean and std.dev: (250.97, 148.54)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 960)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (90, 487, 4562)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 13506)
[M::mem_pestat] mean and std.dev: (2268.85, 2918.72)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 17978)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (98, 186, 300)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 704)
[M::mem_pestat] mean and std.dev: (205.43, 132.60)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 906)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100588 reads in 4.581 CPU sec, 4.168 real sec
[M::process] read 100794 sequences (10000146 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (156, 48355, 14, 118)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (97, 189, 296)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 694)
[M::mem_pestat] mean and std.dev: (204.92, 134.04)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 893)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (134, 217, 342)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 758)
[M::mem_pestat] mean and std.dev: (250.75, 151.11)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 966)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (1135, 2419, 4627)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 11611)
[M::mem_pestat] mean and std.dev: (2809.36, 2134.89)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 15103)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (99, 172, 302)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 708)
[M::mem_pestat] mean and std.dev: (207.10, 152.57)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 911)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100774 reads in 6.716 CPU sec, 6.260 real sec
[M::process] read 100854 sequences (10000199 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (142, 48320, 13, 105)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (94, 185, 307)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 733)
[M::mem_pestat] mean and std.dev: (208.82, 133.66)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 946)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (134, 217, 338)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 746)
[M::mem_pestat] mean and std.dev: (248.17, 147.58)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 950)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (455, 1488, 4647)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 13031)
[M::mem_pestat] mean and std.dev: (2276.46, 2256.42)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 17223)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (92, 160, 282)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 662)
[M::mem_pestat] mean and std.dev: (193.53, 132.85)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 852)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100794 reads in 7.484 CPU sec, 6.925 real sec
[M::process] read 100912 sequences (10000064 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (123, 48399, 14, 113)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (109, 195, 312)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 718)
[M::mem_pestat] mean and std.dev: (216.16, 135.98)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 921)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (134, 217, 337)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 743)
[M::mem_pestat] mean and std.dev: (247.75, 146.81)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 946)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (270, 527, 4334)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 12462)
[M::mem_pestat] mean and std.dev: (2220.00, 2628.00)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 16526)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (101, 175, 276)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 626)
[M::mem_pestat] mean and std.dev: (196.58, 123.22)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 801)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100854 reads in 7.148 CPU sec, 6.696 real sec
[M::process] read 100816 sequences (10000034 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (124, 48453, 22, 116)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (94, 196, 313)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 751)
[M::mem_pestat] mean and std.dev: (218.52, 153.16)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 970)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (135, 217, 340)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 750)
[M::mem_pestat] mean and std.dev: (248.97, 147.42)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 955)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (931, 1728, 2565)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 5833)
[M::mem_pestat] mean and std.dev: (1952.14, 1340.69)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 7467)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (100, 169, 286)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 658)
[M::mem_pestat] mean and std.dev: (200.65, 131.29)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 844)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100912 reads in 5.253 CPU sec, 4.818 real sec
[M::process] read 100632 sequences (10000058 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (134, 48376, 16, 129)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (78, 161, 282)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 690)
[M::mem_pestat] mean and std.dev: (189.01, 139.52)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 894)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (136, 218, 338)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 742)
[M::mem_pestat] mean and std.dev: (249.51, 147.63)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 944)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (787, 1688, 4414)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 11668)
[M::mem_pestat] mean and std.dev: (2258.19, 2055.95)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 15295)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (107, 186, 310)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 716)
[M::mem_pestat] mean and std.dev: (221.97, 153.45)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 919)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100816 reads in 5.821 CPU sec, 5.396 real sec
[M::process] read 100698 sequences (10000068 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (135, 48290, 17, 126)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (93, 171, 308)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 738)
[M::mem_pestat] mean and std.dev: (214.76, 148.46)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 953)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (137, 220, 344)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 758)
[M::mem_pestat] mean and std.dev: (252.90, 151.01)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 965)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (734, 1950, 4600)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 12332)
[M::mem_pestat] mean and std.dev: (2211.82, 1748.12)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 16198)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (88, 171, 261)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 607)
[M::mem_pestat] mean and std.dev: (191.72, 126.89)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 780)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100632 reads in 6.131 CPU sec, 5.482 real sec
[M::process] read 100754 sequences (10000037 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (129, 48448, 8, 119)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (99, 172, 309)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 729)
[M::mem_pestat] mean and std.dev: (207.52, 142.38)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 939)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (136, 221, 345)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 763)
[M::mem_pestat] mean and std.dev: (253.10, 150.81)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 972)
[M::mem_pestat] skip orientation RF as there are not enough pairs
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (109, 162, 251)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 535)
[M::mem_pestat] mean and std.dev: (179.99, 103.52)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 677)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100698 reads in 6.964 CPU sec, 6.352 real sec
[M::process] read 100780 sequences (10000140 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (139, 48391, 12, 133)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (100, 216, 294)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 682)
[M::mem_pestat] mean and std.dev: (212.88, 132.85)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 876)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (134, 218, 340)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 752)
[M::mem_pestat] mean and std.dev: (249.30, 148.82)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 958)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (333, 663, 2283)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 6183)
[M::mem_pestat] mean and std.dev: (1345.67, 1556.02)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 8133)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (98, 182, 308)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 728)
[M::mem_pestat] mean and std.dev: (211.27, 139.20)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 938)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100754 reads in 5.064 CPU sec, 4.690 real sec
[M::process] read 100916 sequences (10000171 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (144, 48414, 14, 134)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (112, 198, 337)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 787)
[M::mem_pestat] mean and std.dev: (231.50, 162.86)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1012)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (134, 217, 339)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 749)
[M::mem_pestat] mean and std.dev: (249.56, 149.55)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 954)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (351, 1155, 3529)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 9885)
[M::mem_pestat] mean and std.dev: (1937.07, 2135.84)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 13063)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (101, 177, 306)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 716)
[M::mem_pestat] mean and std.dev: (208.58, 140.17)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 921)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100780 reads in 5.275 CPU sec, 4.912 real sec
[M::process] read 100820 sequences (10000058 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (154, 48426, 12, 125)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (86, 162, 315)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 773)
[M::mem_pestat] mean and std.dev: (214.22, 164.53)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1002)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (135, 217, 339)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 747)
[M::mem_pestat] mean and std.dev: (248.66, 146.82)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 951)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (106, 288, 2799)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 8185)
[M::mem_pestat] mean and std.dev: (1396.08, 1936.13)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 10878)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (105, 174, 275)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 615)
[M::mem_pestat] mean and std.dev: (195.39, 122.54)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 785)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100916 reads in 5.593 CPU sec, 5.162 real sec
[M::process] read 100774 sequences (10000100 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (151, 48365, 10, 127)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (99, 170, 291)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 675)
[M::mem_pestat] mean and std.dev: (193.05, 123.22)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 867)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (136, 218, 341)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 751)
[M::mem_pestat] mean and std.dev: (250.54, 149.34)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 956)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (617, 2603, 3175)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 8291)
[M::mem_pestat] mean and std.dev: (2071.90, 1648.36)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 10849)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (113, 192, 330)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 764)
[M::mem_pestat] mean and std.dev: (228.35, 148.75)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 981)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100820 reads in 6.445 CPU sec, 5.949 real sec
[M::process] read 100642 sequences (10000087 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (155, 48316, 14, 167)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (110, 203, 313)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 719)
[M::mem_pestat] mean and std.dev: (221.76, 142.17)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 922)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (135, 218, 342)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 756)
[M::mem_pestat] mean and std.dev: (250.97, 149.45)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 963)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (185, 688, 2004)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 5642)
[M::mem_pestat] mean and std.dev: (1221.07, 1271.74)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 7461)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (101, 170, 303)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 707)
[M::mem_pestat] mean and std.dev: (213.10, 151.32)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 909)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100774 reads in 4.618 CPU sec, 4.202 real sec
[M::process] read 100656 sequences (10000186 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (163, 48338, 12, 110)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (97, 171, 281)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 649)
[M::mem_pestat] mean and std.dev: (200.79, 131.89)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 833)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (136, 218, 340)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 748)
[M::mem_pestat] mean and std.dev: (250.05, 148.24)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 952)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (348, 1028, 2355)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 6369)
[M::mem_pestat] mean and std.dev: (1433.25, 1487.40)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 8376)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (106, 186, 326)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 766)
[M::mem_pestat] mean and std.dev: (219.56, 150.32)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 986)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100642 reads in 4.837 CPU sec, 4.507 real sec
[M::process] read 100764 sequences (10000070 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (147, 48229, 17, 126)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (113, 182, 304)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 686)
[M::mem_pestat] mean and std.dev: (213.81, 137.65)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 877)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (135, 217, 341)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 753)
[M::mem_pestat] mean and std.dev: (250.57, 149.60)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 959)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (247, 606, 4628)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 13390)
[M::mem_pestat] mean and std.dev: (2136.29, 2391.63)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 17771)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (97, 188, 300)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 706)
[M::mem_pestat] mean and std.dev: (215.20, 147.72)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 909)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100656 reads in 4.648 CPU sec, 4.269 real sec
[M::process] read 100726 sequences (10000059 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (167, 48329, 9, 124)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (107, 186, 300)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 686)
[M::mem_pestat] mean and std.dev: (214.47, 137.18)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 879)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (132, 216, 336)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 744)
[M::mem_pestat] mean and std.dev: (246.31, 146.24)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 948)
[M::mem_pestat] skip orientation RF as there are not enough pairs
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (84, 165, 278)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 666)
[M::mem_pestat] mean and std.dev: (189.51, 130.78)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 860)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100764 reads in 4.856 CPU sec, 4.518 real sec
[M::process] read 100982 sequences (10000188 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (137, 48340, 18, 123)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (104, 203, 344)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 824)
[M::mem_pestat] mean and std.dev: (231.87, 160.24)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1064)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (135, 216, 338)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 744)
[M::mem_pestat] mean and std.dev: (248.47, 147.21)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 947)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (990, 1942, 2939)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 6837)
[M::mem_pestat] mean and std.dev: (1999.94, 1250.99)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 8786)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (89, 169, 329)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 809)
[M::mem_pestat] mean and std.dev: (203.31, 155.49)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 1049)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100726 reads in 4.802 CPU sec, 4.429 real sec
[M::process] read 100826 sequences (10000167 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (129, 48496, 5, 122)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (110, 188, 311)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 713)
[M::mem_pestat] mean and std.dev: (211.93, 134.83)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 914)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (132, 212, 328)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 720)
[M::mem_pestat] mean and std.dev: (242.62, 143.28)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 916)
[M::mem_pestat] skip orientation RF as there are not enough pairs
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (111, 178, 292)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 654)
[M::mem_pestat] mean and std.dev: (199.98, 132.24)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 835)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100982 reads in 4.795 CPU sec, 4.452 real sec
[M::process] read 100796 sequences (10000043 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (167, 48388, 14, 116)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (88, 160, 294)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 706)
[M::mem_pestat] mean and std.dev: (194.71, 133.68)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 912)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (133, 213, 332)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 730)
[M::mem_pestat] mean and std.dev: (244.25, 144.38)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 929)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (82, 562, 2543)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 7465)
[M::mem_pestat] mean and std.dev: (1426.29, 1673.00)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 9926)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (103, 174, 278)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 628)
[M::mem_pestat] mean and std.dev: (203.96, 133.28)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 803)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100826 reads in 4.840 CPU sec, 4.467 real sec
[M::process] read 100776 sequences (10000050 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (141, 48412, 14, 111)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (91, 179, 315)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 763)
[M::mem_pestat] mean and std.dev: (210.72, 143.83)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 987)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (134, 215, 333)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 731)
[M::mem_pestat] mean and std.dev: (245.25, 144.12)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 930)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (80, 1458, 1590)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 4610)
[M::mem_pestat] mean and std.dev: (1063.08, 1228.64)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 6120)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (84, 149, 261)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 615)
[M::mem_pestat] mean and std.dev: (171.86, 111.57)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 792)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100796 reads in 4.864 CPU sec, 4.510 real sec
[M::process] read 100696 sequences (10000047 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (137, 48364, 16, 128)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (93, 174, 280)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 654)
[M::mem_pestat] mean and std.dev: (194.14, 126.74)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 841)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (135, 219, 342)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 756)
[M::mem_pestat] mean and std.dev: (252.03, 150.63)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 963)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (177, 1149, 3290)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 9516)
[M::mem_pestat] mean and std.dev: (1559.81, 1674.12)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 12629)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (107, 171, 290)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 656)
[M::mem_pestat] mean and std.dev: (200.59, 132.66)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 839)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100776 reads in 4.935 CPU sec, 4.568 real sec
[M::process] read 100824 sequences (10000110 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (131, 48349, 16, 138)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (120, 207, 320)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 720)
[M::mem_pestat] mean and std.dev: (226.34, 139.43)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 920)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (134, 216, 337)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 743)
[M::mem_pestat] mean and std.dev: (247.49, 147.06)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 946)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (339, 597, 1396)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 3510)
[M::mem_pestat] mean and std.dev: (690.14, 606.84)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 4567)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (110, 194, 328)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 764)
[M::mem_pestat] mean and std.dev: (234.04, 150.15)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 982)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100696 reads in 4.610 CPU sec, 4.227 real sec
[M::process] read 101226 sequences (10000143 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (138, 48390, 14, 130)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (99, 179, 306)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 720)
[M::mem_pestat] mean and std.dev: (206.48, 133.10)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 927)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (135, 217, 339)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 747)
[M::mem_pestat] mean and std.dev: (248.70, 147.62)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 951)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (157, 1420, 2665)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 7681)
[M::mem_pestat] mean and std.dev: (1680.86, 1711.35)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 10189)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (102, 182, 291)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 669)
[M::mem_pestat] mean and std.dev: (209.51, 137.10)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 858)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 100824 reads in 4.666 CPU sec, 4.255 real sec
[M::process] read 81326 sequences (7713337 bp)...
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (138, 48556, 13, 112)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (90, 184, 289)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 687)
[M::mem_pestat] mean and std.dev: (201.02, 132.53)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 886)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (134, 216, 336)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 740)
[M::mem_pestat] mean and std.dev: (246.82, 145.68)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 942)
[M::mem_pestat] analyzing insert size distribution for orientation RF...
[M::mem_pestat] (25, 50, 75) percentile: (436, 1311, 1920)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 4888)
[M::mem_pestat] mean and std.dev: (1478.85, 1270.67)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 6372)
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (109, 184, 311)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 715)
[M::mem_pestat] mean and std.dev: (206.60, 130.31)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 917)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 101226 reads in 4.904 CPU sec, 4.536 real sec
[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (82, 38793, 8, 88)
[M::mem_pestat] analyzing insert size distribution for orientation FF...
[M::mem_pestat] (25, 50, 75) percentile: (88, 175, 286)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 682)
[M::mem_pestat] mean and std.dev: (197.04, 140.76)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 880)
[M::mem_pestat] analyzing insert size distribution for orientation FR...
[M::mem_pestat] (25, 50, 75) percentile: (109, 177, 294)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 664)
[M::mem_pestat] mean and std.dev: (212.22, 135.62)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 849)
[M::mem_pestat] skip orientation RF as there are not enough pairs
[M::mem_pestat] analyzing insert size distribution for orientation RR...
[M::mem_pestat] (25, 50, 75) percentile: (77, 147, 228)
[M::mem_pestat] low and high boundaries for computing mean and std.dev: (1, 530)
[M::mem_pestat] mean and std.dev: (170.78, 121.00)
[M::mem_pestat] low and high boundaries for proper pairs: (1, 681)
[M::mem_pestat] skip orientation FF
[M::mem_pestat] skip orientation RR
[M::mem_process_seqs] Processed 81326 reads in 4.220 CPU sec, 3.933 real sec
[main] Version: 0.7.12-r1039
[main] CMD: bwa mem -R @RG\tID:G04870\tSM:G04870\tPL:Illumina -M NC000962_3.fasta G04870_1_trimmed_paired.fastq G04870_2_trimmed_paired.fastq
[main] Real time: 371.804 sec; CPU: 402.952 sec


>>>>> samtools_faidx_reference_genome <<<<<


samtools faidx NC000962_3.fasta


>>>>> convert_sam_file_to_bam_file <<<<<


samtools view -bt NC000962_3.fasta.fai G04870.sam > G04870.bam


>>>>> sort_bam_file <<<<<

samtools sort G04870.bam -o G04870.sorted.bam
[bam_sort_core] merging from 4 files...


>>>>> samtools_index_sorted_bam <<<<<


samtools index G04870.sorted.bam


>>>>> mapping_statistics <<<<<


samtools flagstat G04870.sorted.bam > G04870_stats.txt


>>>>> samtools_mpileup <<<<<

samtools mpileup -Q 23 -d 2000 -C 50 -ugf NC000962_3.fasta G04870.sorted.bam | bcftools call -O v -vm -o G04870.raw.vcf
Note: none of --samples-file, --ploidy or --ploidy-file given, assuming all sites are diploid
[mpileup] 1 samples in 1 input files
<mpileup> Set max per-file depth to 8000


>>>>> vcfutils_filter <<<<<

vcfutils.pl varFilter -d 10 -D 2000 G04870.raw.vcf > G04870.filt.vcf


>>>>> bgzip_filt_file <<<<<

bgzip -c G04870.filt.vcf > G04870.filt.vcf.gz


>>>>> run_tabix <<<<<


tabix -p vcf G04870.filt.vcf.gz


>>>>> snpEff <<<<<


java -Xmx4g -jar /opt/snpEff/snpEff.jar -no-downstream -no-upstream -v -c /opt/snpEff/snpEff.config NC000962_3 G04870.filt.vcf > G04870.ann.vcf.gz
00:00:00    SnpEff version SnpEff 4.3p (build 2017-06-06 09:55), by Pablo Cingolani
00:00:00    Command: 'ann'
00:00:00    Reading configuration file '/opt/snpEff/snpEff.config'. Genome: 'NC000962_3'
00:00:00    Reading config file: /opt/snpEff/snpEff.config
00:00:00    done
00:00:00    Reading database for genome version 'NC000962_3' from file '/opt/snpEff/./data/NC000962_3/snpEffectPredictor.bin' (this might take a while)
00:00:01    done
00:00:01    Loading Motifs and PWMs
00:00:01    Building interval forest
00:00:01    done.
00:00:01    Genome stats :
#-----------------------------------------------
# Genome name                : 'Mycobacterium tuberculosis'
# Genome version             : 'NC000962_3'
# Genome ID                  : 'NC000962_3[0]'
# Has protein coding info    : true
# Has Tr. Support Level info : true
# Genes                      : 4111
# Protein coding genes       : 4018
#-----------------------------------------------
# Transcripts                : 4018
# Avg. transcripts per gene  : 0.98
# TSL transcripts            : 0
#-----------------------------------------------
# Checked transcripts        : 
#               AA sequences :   4018 ( 100.00% )
#              DNA sequences :      0 ( 0.00% )
#-----------------------------------------------
# Protein coding transcripts : 4018
#              Length errors :      0 ( 0.00% )
#  STOP codons in CDS errors :      0 ( 0.00% )
#         START codon errors :     27 ( 0.67% )
#        STOP codon warnings :      0 ( 0.00% )
#              UTR sequences :      0 ( 0.00% )
#               Total Errors :     27 ( 0.67% )
# WARNING                    : No protein coding transcript has UTR
#-----------------------------------------------
# Cds                        : 4018
# Exons                      : 4018
# Exons with sequence        : 4018
# Exons without sequence     : 0
# Avg. exons per transcript  : 1.00
#-----------------------------------------------
# Number of chromosomes      : 1
# Chromosomes                : Format 'chromo_name size codon_table'
#       'NC000962_3'    4411532 Bacterial_and_Plant_Plastid
#-----------------------------------------------

00:00:01    Predicting variants
00:00:02    Creating sequences from exon information 'NC000962_3'
00:00:02    Building sequence tree for chromosome 'NC000962_3'
00:00:02    Building sequence tree for genome sequences
00:00:02    Done.
00:00:02    Done. Loaded 3228 sequences.

WARNINGS: Some warning were detected
Warning type    Number of warnings
WARNING_TRANSCRIPT_NO_START_CODON   179


00:00:04    Creating summary file: snpEff_summary.html
00:00:04    Creating genes file: snpEff_genes.txt
00:00:05    done.
00:00:05    Logging
00:00:07    Checking for updates...


NEW VERSION!
    There is a new SnpEff version available: 
        Version      : 4.3T
        Release date : 2017-11-24
        Download URL : http://sourceforge.net/projects/snpeff/files/snpEff_latest_core.zip

00:00:08    Done.


>>>>> velveth_assembly <<<<<

velveth G04870_41 41 -fastq -shortPaired  G04870_1_trimmed_paired.fastq G04870_1_trimmed_unpaired.fastq -fastq -short G04870_2_trimmed_paired.fastq G04870_2_trimmed_unpaired.fastq
[0.000000] Reading FastQ file G04870_1_trimmed_paired.fastq;
[28.645339] 3965294 sequences found
[28.645349] Done
[28.645842] Reading FastQ file G04870_1_trimmed_unpaired.fastq;
[30.500079] 338721 sequences found
[30.500089] Done
[30.500647] Reading FastQ file G04870_2_trimmed_paired.fastq;
[61.333691] 3965294 sequences found
[61.333702] Done
[61.334344] Reading FastQ file G04870_2_trimmed_unpaired.fastq;
[61.893720] 76531 sequences found
[61.893732] Done
[61.925623] Reading read set file G04870_41/Sequences;
[81.464889] 8345840 sequences found
[122.638820] Done
[122.638840] 8345840 sequences in total.
[122.639684] Writing into roadmap file G04870_41/Roadmaps...
[130.248099] Inputting sequences...
[130.248126] Inputting sequence 0 / 8345840
[146.065063] Inputting sequence 1000000 / 8345840
[162.559007] Inputting sequence 2000000 / 8345840
[179.785216] Inputting sequence 3000000 / 8345840
[196.989549] Inputting sequence 4000000 / 8345840
[213.117888] Inputting sequence 5000000 / 8345840
[229.982101] Inputting sequence 6000000 / 8345840
[247.529346] Inputting sequence 7000000 / 8345840
[264.993409] Inputting sequence 8000000 / 8345840
[271.179870]  === Sequences loaded in 140.962295 s
[271.184977] Done inputting sequences
[271.184992] Destroying splay table
[271.268386] Splay table destroyed


>>>>> velvetg_produce_graph <<<<<

velvetg G04870_41 -exp_cov auto -cov_cutoff auto
[0.000000] Reading roadmap file G04870_41/Roadmaps
[25.153802] 8345840 roadmaps read
[25.154187] Creating insertion markers
[28.313368] Ordering insertion markers
[36.459880] Counting preNodes
[37.533385] 4882557 preNodes counted, creating them now
[44.085453] Sequence 1000000 / 8345840
[48.407713] Sequence 2000000 / 8345840
[52.646077] Sequence 3000000 / 8345840
[56.750361] Sequence 4000000 / 8345840
[60.903644] Sequence 5000000 / 8345840
[65.016070] Sequence 6000000 / 8345840
[69.161567] Sequence 7000000 / 8345840
[73.211198] Sequence 8000000 / 8345840
[74.554354] Adjusting marker info...
[76.081702] Connecting preNodes
[78.087111] Connecting 1000000 / 8345840
[80.292781] Connecting 2000000 / 8345840
[82.575853] Connecting 3000000 / 8345840
[84.897287] Connecting 4000000 / 8345840
[87.163824] Connecting 5000000 / 8345840
[89.610255] Connecting 6000000 / 8345840
[92.043184] Connecting 7000000 / 8345840
[94.617858] Connecting 8000000 / 8345840
[95.398131] Cleaning up memory
[95.399594] Done creating preGraph
[95.399612] Concatenation...
[96.828822] Renumbering preNodes
[96.828847] Initial preNode count 4882557
[97.029959] Destroyed 3198724 preNodes
[97.029980] Concatenation over!
[97.029982] Clipping short tips off preGraph
[97.300228] Concatenation...
[97.905756] Renumbering preNodes
[97.905778] Initial preNode count 1683833
[98.050012] Destroyed 619848 preNodes
[98.050031] Concatenation over!
[98.050033] 333228 tips cut off
[98.050035] 1063985 nodes left
[98.052405] Writing into pregraph file G04870_41/PreGraph...
[101.792610] Reading read set file G04870_41/Sequences;
[120.765255] 8345840 sequences found
[160.341978] Done
[167.368718] Reading pre-graph file G04870_41/PreGraph
[167.402387] Graph has 1063985 nodes and 8345840 sequences
[169.551553] Scanning pre-graph file G04870_41/PreGraph for k-mers
[170.969392] 16883347 kmers found
[173.255986] Sorting kmer occurence table ... 
[185.356357] Sorting done.
[185.356380] Computing acceleration table... 
[185.500639] Computing offsets... 
[185.609397] Ghost Threading through reads 0 / 8345840
[212.206674] Ghost Threading through reads 1000000 / 8345840
[243.087852] Ghost Threading through reads 2000000 / 8345840
[272.542865] Ghost Threading through reads 3000000 / 8345840
[297.886823] Ghost Threading through reads 4000000 / 8345840
[321.259063] Ghost Threading through reads 5000000 / 8345840
[345.391220] Ghost Threading through reads 6000000 / 8345840
[368.979763] Ghost Threading through reads 7000000 / 8345840
[394.473803] Ghost Threading through reads 8000000 / 8345840
[402.599484]  === Ghost-Threaded in 216.990087 s
[402.599509] Threading through reads 0 / 8345840
[429.918109] Threading through reads 1000000 / 8345840
[459.322399] Threading through reads 2000000 / 8345840
[488.948944] Threading through reads 3000000 / 8345840
[517.872595] Threading through reads 4000000 / 8345840
[548.299762] Threading through reads 5000000 / 8345840
[580.523341] Threading through reads 6000000 / 8345840
[609.020181] Threading through reads 7000000 / 8345840
[636.368751] Threading through reads 8000000 / 8345840
[644.902928]  === Threaded in 242.303419 s
[646.860587] Correcting graph with cutoff 0.200000
[646.903023] Determining eligible starting points
[648.517191] Done listing starting nodes
[648.517217] Initializing todo lists
[648.812730] Done with initilization
[648.812755] Activating arc lookup table
[649.420129] Done activating arc lookup table
[649.455212] 10000 / 1063985 nodes visited
[649.490822] 20000 / 1063985 nodes visited
[649.525919] 30000 / 1063985 nodes visited
[649.559924] 40000 / 1063985 nodes visited
[649.593290] 50000 / 1063985 nodes visited
[649.626654] 60000 / 1063985 nodes visited
[649.659904] 70000 / 1063985 nodes visited
[649.690857] 80000 / 1063985 nodes visited
[649.728274] 90000 / 1063985 nodes visited
[649.762097] 100000 / 1063985 nodes visited
[649.793432] 110000 / 1063985 nodes visited
[649.827209] 120000 / 1063985 nodes visited
[649.868586] 130000 / 1063985 nodes visited
[649.905793] 140000 / 1063985 nodes visited
[649.941776] 150000 / 1063985 nodes visited
[649.972234] 160000 / 1063985 nodes visited
[650.011053] 170000 / 1063985 nodes visited
[650.040161] 180000 / 1063985 nodes visited
[650.071496] 190000 / 1063985 nodes visited
[650.101765] 200000 / 1063985 nodes visited
[650.133806] 210000 / 1063985 nodes visited
[650.168143] 220000 / 1063985 nodes visited
[650.211571] 230000 / 1063985 nodes visited
[650.244204] 240000 / 1063985 nodes visited
[650.278957] 250000 / 1063985 nodes visited
[650.339085] 260000 / 1063985 nodes visited
[650.406878] 270000 / 1063985 nodes visited
[650.556904] 280000 / 1063985 nodes visited
[650.715561] 290000 / 1063985 nodes visited
[650.857615] 300000 / 1063985 nodes visited
[651.025221] 310000 / 1063985 nodes visited
[651.235179] 320000 / 1063985 nodes visited
[651.397039] 330000 / 1063985 nodes visited
[651.691209] 340000 / 1063985 nodes visited
[651.956448] 350000 / 1063985 nodes visited
[652.179985] 360000 / 1063985 nodes visited
[652.355913] 370000 / 1063985 nodes visited
[652.620741] 380000 / 1063985 nodes visited
[652.780706] 390000 / 1063985 nodes visited
[652.898257] 400000 / 1063985 nodes visited
[653.060301] 410000 / 1063985 nodes visited
[653.254693] 420000 / 1063985 nodes visited
[653.397882] 430000 / 1063985 nodes visited
[653.541968] 440000 / 1063985 nodes visited
[653.700141] 450000 / 1063985 nodes visited
[653.902530] 460000 / 1063985 nodes visited
[654.123954] 470000 / 1063985 nodes visited
[654.368846] 480000 / 1063985 nodes visited
[654.690454] 490000 / 1063985 nodes visited
[654.923533] 500000 / 1063985 nodes visited
[655.164603] 510000 / 1063985 nodes visited
[655.327378] 520000 / 1063985 nodes visited
[655.512451] 530000 / 1063985 nodes visited
[655.703851] 540000 / 1063985 nodes visited
[655.964408] 550000 / 1063985 nodes visited
[656.149557] 560000 / 1063985 nodes visited
[656.322965] 570000 / 1063985 nodes visited
[656.476104] 580000 / 1063985 nodes visited
[656.625239] 590000 / 1063985 nodes visited
[656.763669] 600000 / 1063985 nodes visited
[656.966262] 610000 / 1063985 nodes visited
[657.091162] 620000 / 1063985 nodes visited
[657.265819] 630000 / 1063985 nodes visited
[657.535158] 640000 / 1063985 nodes visited
[657.730120] 650000 / 1063985 nodes visited
[657.923019] 660000 / 1063985 nodes visited
[658.081395] 670000 / 1063985 nodes visited
[658.241091] 680000 / 1063985 nodes visited
[658.416036] 690000 / 1063985 nodes visited
[658.772932] 700000 / 1063985 nodes visited
[658.986279] 710000 / 1063985 nodes visited
[659.146258] 720000 / 1063985 nodes visited
[659.382530] 730000 / 1063985 nodes visited
[659.532459] 740000 / 1063985 nodes visited
[659.672106] 750000 / 1063985 nodes visited
[659.808369] 760000 / 1063985 nodes visited
[659.976220] 770000 / 1063985 nodes visited
[660.115427] 780000 / 1063985 nodes visited
[660.279067] 790000 / 1063985 nodes visited
[660.476883] 800000 / 1063985 nodes visited
[660.690486] 810000 / 1063985 nodes visited
[660.999339] 820000 / 1063985 nodes visited
[661.223819] 830000 / 1063985 nodes visited
[661.494870] 840000 / 1063985 nodes visited
[661.690028] 850000 / 1063985 nodes visited
[661.935463] 860000 / 1063985 nodes visited
[662.240483] 870000 / 1063985 nodes visited
[662.510059] 880000 / 1063985 nodes visited
[662.717618] 890000 / 1063985 nodes visited
[663.032737] 900000 / 1063985 nodes visited
[663.409272] 910000 / 1063985 nodes visited
[663.716111] 920000 / 1063985 nodes visited
[663.953919] 930000 / 1063985 nodes visited
[664.408321] 940000 / 1063985 nodes visited
[664.740063] 950000 / 1063985 nodes visited
[665.188460] 960000 / 1063985 nodes visited
[665.364922] 970000 / 1063985 nodes visited
[665.662028] 980000 / 1063985 nodes visited
[665.903063] 990000 / 1063985 nodes visited
[666.288862] 1000000 / 1063985 nodes visited
[666.544375] 1010000 / 1063985 nodes visited
[666.835953] 1020000 / 1063985 nodes visited
[667.063819] 1030000 / 1063985 nodes visited
[667.215784] 1040000 / 1063985 nodes visited
[667.410075] 1050000 / 1063985 nodes visited
[667.566809] 1060000 / 1063985 nodes visited
[667.796177] 1070000 / 1063985 nodes visited
[667.961889] 1080000 / 1063985 nodes visited
[668.127354] 1090000 / 1063985 nodes visited
[668.294175] 1100000 / 1063985 nodes visited
[668.478036] 1110000 / 1063985 nodes visited
[668.746384] 1120000 / 1063985 nodes visited
[668.958070] 1130000 / 1063985 nodes visited
[669.154033] 1140000 / 1063985 nodes visited
[669.354483] 1150000 / 1063985 nodes visited
[669.611150] 1160000 / 1063985 nodes visited
[669.885716] 1170000 / 1063985 nodes visited
[670.275530] 1180000 / 1063985 nodes visited
[670.629697] 1190000 / 1063985 nodes visited
[670.933569] 1200000 / 1063985 nodes visited
[671.365609] 1210000 / 1063985 nodes visited
[671.761223] 1220000 / 1063985 nodes visited
[672.059958] 1230000 / 1063985 nodes visited
[672.394499] 1240000 / 1063985 nodes visited
[672.757499] 1250000 / 1063985 nodes visited
[673.142292] 1260000 / 1063985 nodes visited
[673.512215] 1270000 / 1063985 nodes visited
[673.765616] 1280000 / 1063985 nodes visited
[674.025607] 1290000 / 1063985 nodes visited
[674.289348] 1300000 / 1063985 nodes visited
[674.572481] 1310000 / 1063985 nodes visited
[674.844906] 1320000 / 1063985 nodes visited
[675.172904] 1330000 / 1063985 nodes visited
[675.498232] 1340000 / 1063985 nodes visited
[675.770689] 1350000 / 1063985 nodes visited
[676.070283] 1360000 / 1063985 nodes visited
[676.384307] 1370000 / 1063985 nodes visited
[676.747881] 1380000 / 1063985 nodes visited
[677.141528] 1390000 / 1063985 nodes visited
[677.638488] 1400000 / 1063985 nodes visited
[678.056004] 1410000 / 1063985 nodes visited
[678.626936] 1420000 / 1063985 nodes visited
[679.336644] 1430000 / 1063985 nodes visited
[679.717649] 1440000 / 1063985 nodes visited
[680.026889] 1450000 / 1063985 nodes visited
[680.296696] 1460000 / 1063985 nodes visited
[680.682006] 1470000 / 1063985 nodes visited
[681.037019] 1480000 / 1063985 nodes visited
[681.367628] 1490000 / 1063985 nodes visited
[681.693186] 1500000 / 1063985 nodes visited
[682.043502] 1510000 / 1063985 nodes visited
[682.404370] 1520000 / 1063985 nodes visited
[682.806461] 1530000 / 1063985 nodes visited
[683.272596] 1540000 / 1063985 nodes visited
[683.953654] 1550000 / 1063985 nodes visited
[684.578341] 1560000 / 1063985 nodes visited
[684.960841] 1570000 / 1063985 nodes visited
[685.380429] 1580000 / 1063985 nodes visited
[685.743572] 1590000 / 1063985 nodes visited
[686.140669] 1600000 / 1063985 nodes visited
[686.534866] 1610000 / 1063985 nodes visited
[687.007710] 1620000 / 1063985 nodes visited
[687.521228] 1630000 / 1063985 nodes visited
[688.335515] 1640000 / 1063985 nodes visited
[688.935821] 1650000 / 1063985 nodes visited
[689.443337] 1660000 / 1063985 nodes visited
[690.038914] 1670000 / 1063985 nodes visited
[690.682164] 1680000 / 1063985 nodes visited
[691.118335] 1690000 / 1063985 nodes visited
[691.474475] 1700000 / 1063985 nodes visited
[692.436002] 1710000 / 1063985 nodes visited
[692.482435] 1720000 / 1063985 nodes visited
[692.524274] 1730000 / 1063985 nodes visited
[692.553487] 1740000 / 1063985 nodes visited
[692.577628] 1750000 / 1063985 nodes visited
[692.664430] 1760000 / 1063985 nodes visited
[692.716160] 1770000 / 1063985 nodes visited
[692.761491] 1780000 / 1063985 nodes visited
[692.813534] 1790000 / 1063985 nodes visited
[692.862172] 1800000 / 1063985 nodes visited
[692.865189] Concatenation...
[693.127352] Renumbering nodes
[693.127383] Initial node count 1063985
[693.204740] Removed 124648 null nodes
[693.204766] Concatenation over!
[693.204768] Clipping short tips off graph, drastic
[698.434336] Concatenation...
[701.599376] Renumbering nodes
[701.599410] Initial node count 939337
[701.617291] Removed 873344 null nodes
[701.617309] Concatenation over!
[701.617313] 65993 nodes left
[701.619763] Writing into graph file G04870_41/Graph2...
[709.113267] Measuring median coverage depth...
[709.173475] Median coverage depth = 98.489362
[709.175194] Removing contigs with coverage < 49.244681...
[709.217178] Concatenation...
[714.253429] Renumbering nodes
[714.253455] Initial node count 65993
[714.253725] Removed 64737 null nodes
[714.253730] Concatenation over!
[714.253771] Concatenation...
[714.253925] Renumbering nodes
[714.253928] Initial node count 1256
[714.253930] Removed 0 null nodes
[714.253932] Concatenation over!
[714.253941] Clipping short tips off graph, drastic
[714.254458] Concatenation...
[714.256320] Renumbering nodes
[714.256339] Initial node count 1256
[714.256367] Removed 103 null nodes
[714.256369] Concatenation over!
[714.256371] 1153 nodes left
[714.256373] Read coherency...
[714.256399] Identifying unique nodes
[714.256425] Done, 732 unique nodes counted
[714.256427] Trimming read tips
[714.256490] Renumbering nodes
[714.256493] Initial node count 1153
[714.256495] Removed 0 null nodes
[714.256497] Confronted to 0 multiple hits and 0 null over 0
[714.256499] Read coherency over!
[714.314117] Starting pebble resolution...
[714.350138] Computing read to node mapping array sizes
[714.598057] Computing read to node mappings
[716.138949] Estimating library insert lengths...
[716.199998] Paired-end library 1 has length: 143, sample standard deviation: 295
[716.200016] Done
[716.200054] Computing direct node to node mappings
[717.079629] Scaffolding node 0
[717.924192]  === Nodes Scaffolded in 1.724135 s
[718.223351] Preparing to correct graph with cutoff 0.200000
[718.230704] Cleaning memory
[718.230727] Deactivating local correction settings
[718.230759] Pebble done.
[718.230762] Starting pebble resolution...
[718.285580] Computing read to node mapping array sizes
[718.619371] Computing read to node mappings
[720.375286] Estimating library insert lengths...
[720.444000] Paired-end library 1 has length: 143, sample standard deviation: 295
[720.444018] Done
[720.444052] Computing direct node to node mappings
[721.548815] Scaffolding node 0
[723.051579]  === Nodes Scaffolded in 2.607525 s
[723.492137] Preparing to correct graph with cutoff 0.200000
[723.498919] Cleaning memory
[723.498969] Deactivating local correction settings
[723.499034] Pebble done.
[723.499043] Concatenation...
[723.499169] Renumbering nodes
[723.499173] Initial node count 1153
[723.499177] Removed 0 null nodes
[723.499187] Concatenation over!
[723.499190] Removing reference contigs with coverage < 49.244681...
[723.499248] Concatenation...
[723.499315] Renumbering nodes
[723.499318] Initial node count 1153
[723.499322] Removed 0 null nodes
[723.499330] Concatenation over!
[723.581829] Writing contigs into G04870_41/contigs.fa...
[726.392327] Writing into stats file G04870_41/stats.txt...
[726.665634] Writing into graph file G04870_41/LastGraph...
[732.515976] Estimated Coverage = 98.489362
[732.515999] Estimated Coverage cutoff = 49.244681
Final graph has 1153 nodes and n50 of 13731, max 54231, total 4232549, using 8151713/8345840 reads


>>>>> assemblathon_stats <<<<<


assemblathon_stats.pl ./G04870_41/contigs.fa


>>>>> velveth_assembly <<<<<

velveth G04870_49 49 -fastq -shortPaired  G04870_1_trimmed_paired.fastq G04870_1_trimmed_unpaired.fastq -fastq -short G04870_2_trimmed_paired.fastq G04870_2_trimmed_unpaired.fastq
[0.000000] Reading FastQ file G04870_1_trimmed_paired.fastq;
[29.718461] 3965294 sequences found
[29.718490] Done
[29.719883] Reading FastQ file G04870_1_trimmed_unpaired.fastq;
[33.540500] 338721 sequences found
[33.540513] Done
[33.541651] Reading FastQ file G04870_2_trimmed_paired.fastq;
[70.642935] 3965294 sequences found
[70.642945] Done
[70.643624] Reading FastQ file G04870_2_trimmed_unpaired.fastq;
[71.170593] 76531 sequences found
[71.170603] Done
[71.196506] Reading read set file G04870_49/Sequences;
[101.004413] 8345840 sequences found
[197.311322] Done
[197.311342] 8345840 sequences in total.
[197.312414] Writing into roadmap file G04870_49/Roadmaps...
[211.477047] Inputting sequences...
[211.477080] Inputting sequence 0 / 8345840
[244.330129] Inputting sequence 1000000 / 8345840
[284.120241] Inputting sequence 2000000 / 8345840
[310.858642] Inputting sequence 3000000 / 8345840
[337.795159] Inputting sequence 4000000 / 8345840
[363.938191] Inputting sequence 5000000 / 8345840
[393.831922] Inputting sequence 6000000 / 8345840
[418.800850] Inputting sequence 7000000 / 8345840
[443.675872] Inputting sequence 8000000 / 8345840
[452.460728]  === Sequences loaded in 241.070395 s
[452.467033] Done inputting sequences
[452.467096] Destroying splay table
[452.571829] Splay table destroyed


>>>>> velvetg_produce_graph <<<<<

velvetg G04870_49 -exp_cov auto -cov_cutoff auto
[0.000000] Reading roadmap file G04870_49/Roadmaps
[50.538225] 8345840 roadmaps read
[50.538725] Creating insertion markers
[56.934688] Ordering insertion markers
[70.278480] Counting preNodes
[71.847915] 4647409 preNodes counted, creating them now
[83.390104] Sequence 1000000 / 8345840
[94.194653] Sequence 2000000 / 8345840
[106.360009] Sequence 3000000 / 8345840
[117.098995] Sequence 4000000 / 8345840
[130.575776] Sequence 5000000 / 8345840
[150.183871] Sequence 6000000 / 8345840
[160.685787] Sequence 7000000 / 8345840
[169.055450] Sequence 8000000 / 8345840
[171.716420] Adjusting marker info...
[174.422999] Connecting preNodes
[177.028716] Connecting 1000000 / 8345840
[180.720442] Connecting 2000000 / 8345840
[184.278461] Connecting 3000000 / 8345840
[188.424319] Connecting 4000000 / 8345840
[191.843003] Connecting 5000000 / 8345840
[195.232720] Connecting 6000000 / 8345840
[198.362011] Connecting 7000000 / 8345840
[201.751162] Connecting 8000000 / 8345840
[203.108707] Cleaning up memory
[203.112055] Done creating preGraph
[203.112325] Concatenation...
[205.318214] Renumbering preNodes
[205.318261] Initial preNode count 4647409
[205.658104] Destroyed 3349265 preNodes
[205.658127] Concatenation over!
[205.658129] Clipping short tips off preGraph
[206.164976] Concatenation...
[206.869221] Renumbering preNodes
[206.869242] Initial preNode count 1298144
[207.065947] Destroyed 774167 preNodes
[207.065971] Concatenation over!
[207.065973] 417477 tips cut off
[207.065974] 523977 nodes left
[207.068851] Writing into pregraph file G04870_49/PreGraph...
[211.474486] Reading read set file G04870_49/Sequences;
[252.785609] 8345840 sequences found
[323.798110] Done
[332.467117] Reading pre-graph file G04870_49/PreGraph
[332.520218] Graph has 523977 nodes and 8345840 sequences
[334.306282] Scanning pre-graph file G04870_49/PreGraph for k-mers
[335.414974] 11984558 kmers found
[337.516499] Sorting kmer occurence table ... 
[354.691274] Sorting done.
[354.691299] Computing acceleration table... 
[354.813264] Computing offsets... 
[354.959487] Ghost Threading through reads 0 / 8345840
[417.516822] Ghost Threading through reads 1000000 / 8345840
[458.730512] Ghost Threading through reads 2000000 / 8345840
[512.199744] Ghost Threading through reads 3000000 / 8345840
[552.056971] Ghost Threading through reads 4000000 / 8345840
[591.070308] Ghost Threading through reads 5000000 / 8345840
[635.502900] Ghost Threading through reads 6000000 / 8345840
[682.662604] Ghost Threading through reads 7000000 / 8345840
[708.979326] Ghost Threading through reads 8000000 / 8345840
[716.530689]  === Ghost-Threaded in 361.571202 s
[716.530719] Threading through reads 0 / 8345840
[741.895829] Threading through reads 1000000 / 8345840
[765.491738] Threading through reads 2000000 / 8345840
[791.497900] Threading through reads 3000000 / 8345840
[813.027592] Threading through reads 4000000 / 8345840
[832.916374] Threading through reads 5000000 / 8345840
[855.226397] Threading through reads 6000000 / 8345840
[878.323724] Threading through reads 7000000 / 8345840
[899.083572] Threading through reads 8000000 / 8345840
[906.577755]  === Threaded in 190.047037 s
[907.385477] Correcting graph with cutoff 0.200000
[907.403725] Determining eligible starting points
[908.135560] Done listing starting nodes
[908.135575] Initializing todo lists
[908.258454] Done with initilization
[908.258475] Activating arc lookup table
[908.532615] Done activating arc lookup table
[908.559036] 10000 / 523977 nodes visited
[908.588471] 20000 / 523977 nodes visited
[908.615658] 30000 / 523977 nodes visited
[908.651589] 40000 / 523977 nodes visited
[908.678312] 50000 / 523977 nodes visited
[908.703958] 60000 / 523977 nodes visited
[908.734065] 70000 / 523977 nodes visited
[908.766829] 80000 / 523977 nodes visited
[908.791994] 90000 / 523977 nodes visited
[908.822237] 100000 / 523977 nodes visited
[908.851646] 110000 / 523977 nodes visited
[908.881127] 120000 / 523977 nodes visited
[908.914772] 130000 / 523977 nodes visited
[908.966515] 140000 / 523977 nodes visited
[909.043387] 150000 / 523977 nodes visited
[909.131428] 160000 / 523977 nodes visited
[909.217251] 170000 / 523977 nodes visited
[909.404665] 180000 / 523977 nodes visited
[909.566204] 190000 / 523977 nodes visited
[909.773487] 200000 / 523977 nodes visited
[910.025150] 210000 / 523977 nodes visited
[910.256434] 220000 / 523977 nodes visited
[910.503418] 230000 / 523977 nodes visited
[910.854247] 240000 / 523977 nodes visited
[910.990974] 250000 / 523977 nodes visited
[911.075773] 260000 / 523977 nodes visited
[911.167366] 270000 / 523977 nodes visited
[911.243901] 280000 / 523977 nodes visited
[911.337726] 290000 / 523977 nodes visited
[911.481180] 300000 / 523977 nodes visited
[911.608482] 310000 / 523977 nodes visited
[911.708994] 320000 / 523977 nodes visited
[911.809121] 330000 / 523977 nodes visited
[911.909556] 340000 / 523977 nodes visited
[912.006166] 350000 / 523977 nodes visited
[912.158969] 360000 / 523977 nodes visited
[912.534452] 370000 / 523977 nodes visited
[912.811303] 380000 / 523977 nodes visited
[913.009554] 390000 / 523977 nodes visited
[913.136447] 400000 / 523977 nodes visited
[913.255463] 410000 / 523977 nodes visited
[913.370040] 420000 / 523977 nodes visited
[913.514242] 430000 / 523977 nodes visited
[913.670523] 440000 / 523977 nodes visited
[913.792206] 450000 / 523977 nodes visited
[913.902946] 460000 / 523977 nodes visited
[914.041330] 470000 / 523977 nodes visited
[914.167014] 480000 / 523977 nodes visited
[914.287989] 490000 / 523977 nodes visited
[914.425826] 500000 / 523977 nodes visited
[914.545517] 510000 / 523977 nodes visited
[914.684325] 520000 / 523977 nodes visited
[914.997077] 530000 / 523977 nodes visited
[915.216924] 540000 / 523977 nodes visited
[915.358950] 550000 / 523977 nodes visited
[915.511941] 560000 / 523977 nodes visited
[915.694770] 570000 / 523977 nodes visited
[915.901447] 580000 / 523977 nodes visited
[916.079216] 590000 / 523977 nodes visited
[916.255218] 600000 / 523977 nodes visited
[916.434322] 610000 / 523977 nodes visited
[916.622394] 620000 / 523977 nodes visited
[916.824035] 630000 / 523977 nodes visited
[917.048519] 640000 / 523977 nodes visited
[917.255089] 650000 / 523977 nodes visited
[917.481606] 660000 / 523977 nodes visited
[917.712545] 670000 / 523977 nodes visited
[917.976768] 680000 / 523977 nodes visited
[918.219946] 690000 / 523977 nodes visited
[918.534361] 700000 / 523977 nodes visited
[918.766015] 710000 / 523977 nodes visited
[919.014417] 720000 / 523977 nodes visited
[919.272857] 730000 / 523977 nodes visited
[919.703893] 740000 / 523977 nodes visited
[920.066368] 750000 / 523977 nodes visited
[920.484757] 760000 / 523977 nodes visited
[920.966046] 770000 / 523977 nodes visited
[921.369988] 780000 / 523977 nodes visited
[921.728229] 790000 / 523977 nodes visited
[922.226864] 800000 / 523977 nodes visited
[922.575956] 810000 / 523977 nodes visited
[923.170771] 820000 / 523977 nodes visited
[923.708314] 830000 / 523977 nodes visited
[924.105715] 840000 / 523977 nodes visited
[924.497225] 850000 / 523977 nodes visited
[924.980466] 860000 / 523977 nodes visited
[925.024044] 870000 / 523977 nodes visited
[925.069201] 880000 / 523977 nodes visited
[925.110780] 890000 / 523977 nodes visited
[925.124585] Concatenation...
[925.203621] Renumbering nodes
[925.203640] Initial node count 523977
[925.220150] Removed 29093 null nodes
[925.220179] Concatenation over!
[925.220181] Clipping short tips off graph, drastic
[926.550494] Concatenation...
[928.024724] Renumbering nodes
[928.024748] Initial node count 494884
[928.028580] Removed 461983 null nodes
[928.028598] Concatenation over!
[928.028600] 32901 nodes left
[928.030923] Writing into graph file G04870_49/Graph2...
[932.617556] Measuring median coverage depth...
[932.633349] Median coverage depth = 86.277904
[932.634244] Removing contigs with coverage < 43.138952...
[932.659255] Concatenation...
[935.206688] Renumbering nodes
[935.206709] Initial node count 32901
[935.206845] Removed 32005 null nodes
[935.206848] Concatenation over!
[935.206872] Concatenation...
[935.207044] Renumbering nodes
[935.207050] Initial node count 896
[935.207053] Removed 0 null nodes
[935.207054] Concatenation over!
[935.207065] Clipping short tips off graph, drastic
[935.207336] Concatenation...
[935.208030] Renumbering nodes
[935.208043] Initial node count 896
[935.208056] Removed 51 null nodes
[935.208058] Concatenation over!
[935.208060] 845 nodes left
[935.208062] Read coherency...
[935.208090] Identifying unique nodes
[935.208110] Done, 537 unique nodes counted
[935.208112] Trimming read tips
[935.208160] Renumbering nodes
[935.208162] Initial node count 845
[935.208165] Removed 0 null nodes
[935.208167] Confronted to 0 multiple hits and 0 null over 0
[935.208168] Read coherency over!
[935.238228] Starting pebble resolution...
[935.267871] Computing read to node mapping array sizes
[935.493970] Computing read to node mappings
[936.918451] Estimating library insert lengths...
[936.978568] Paired-end library 1 has length: 50, sample standard deviation: 107
[936.978588] Done
[936.978622] Computing direct node to node mappings
[937.787289] Scaffolding node 0
[938.557253]  === Nodes Scaffolded in 1.578630 s
[938.723400] Preparing to correct graph with cutoff 0.200000
[938.724857] Cleaning memory
[938.724869] Deactivating local correction settings
[938.724894] Pebble done.
[938.724896] Starting pebble resolution...
[938.752933] Computing read to node mapping array sizes
[938.971989] Computing read to node mappings
[940.486576] Estimating library insert lengths...
[940.547098] Paired-end library 1 has length: 50, sample standard deviation: 107
[940.547119] Done
[940.547146] Computing direct node to node mappings
[941.397252] Scaffolding node 0
[942.226662]  === Nodes Scaffolded in 1.679515 s
[942.455738] Preparing to correct graph with cutoff 0.200000
[942.457861] Cleaning memory
[942.457880] Deactivating local correction settings
[942.457915] Pebble done.
[942.457920] Concatenation...
[942.457988] Renumbering nodes
[942.457992] Initial node count 845
[942.457996] Removed 0 null nodes
[942.458004] Concatenation over!
[942.458006] Removing reference contigs with coverage < 43.138952...
[942.458043] Concatenation...
[942.458092] Renumbering nodes
[942.458095] Initial node count 845
[942.458098] Removed 0 null nodes
[942.458105] Concatenation over!
[942.485673] Writing contigs into G04870_49/contigs.fa...
[944.890288] Writing into stats file G04870_49/stats.txt...
[945.005476] Writing into graph file G04870_49/LastGraph...
[948.856306] Estimated Coverage = 86.277904
[948.856336] Estimated Coverage cutoff = 43.138952
Final graph has 845 nodes and n50 of 17253, max 67661, total 4243941, using 8003731/8345840 reads


>>>>> assemblathon_stats <<<<<


assemblathon_stats.pl ./G04870_49/contigs.fa


>>>>> velveth_assembly
 <<<<<

velveth G04870_55 55 -fastq -shortPaired  G04870_1_trimmed_paired.fastq G04870_1_trimmed_unpaired.fastq -fastq -short G04870_2_trimmed_paired.fastq G04870_2_trimmed_unpaired.fastq
[0.000000] Reading FastQ file G04870_1_trimmed_paired.fastq;
[24.092233] 3965294 sequences found
[24.092242] Done
[24.092867] Reading FastQ file G04870_1_trimmed_unpaired.fastq;
[25.969469] 338721 sequences found
[25.969479] Done
[25.970124] Reading FastQ file G04870_2_trimmed_paired.fastq;
[50.133212] 3965294 sequences found
[50.133222] Done
[50.134070] Reading FastQ file G04870_2_trimmed_unpaired.fastq;
[50.508560] 76531 sequences found
[50.508570] Done
[50.532366] Reading read set file G04870_55/Sequences;
[75.235989] 8345840 sequences found
[123.013107] Done
[123.013128] 8345840 sequences in total.
[123.013900] Writing into roadmap file G04870_55/Roadmaps...
[130.407924] Inputting sequences...
[130.407947] Inputting sequence 0 / 8345840
[143.651479] Inputting sequence 1000000 / 8345840
[157.698186] Inputting sequence 2000000 / 8345840
[173.669211] Inputting sequence 3000000 / 8345840
[199.766225] Inputting sequence 4000000 / 8345840
[223.865073] Inputting sequence 5000000 / 8345840
[247.498949] Inputting sequence 6000000 / 8345840
[268.634016] Inputting sequence 7000000 / 8345840
[292.532487] Inputting sequence 8000000 / 8345840
[300.914580]  === Sequences loaded in 170.537393 s
[300.919857] Done inputting sequences
[300.919956] Destroying splay table
[301.077892] Splay table destroyed


>>>>> velvetg_produce_graph
 <<<<<

velvetg G04870_55 -exp_cov auto -cov_cutoff auto
[0.000000] Reading roadmap file G04870_55/Roadmaps
[65.584819] 8345840 roadmaps read
[65.586932] Creating insertion markers
[79.659734] Ordering insertion markers
[93.883963] Counting preNodes
[96.328971] 4475261 preNodes counted, creating them now
[109.478091] Sequence 1000000 / 8345840
[119.172354] Sequence 2000000 / 8345840
[127.068342] Sequence 3000000 / 8345840
[132.439930] Sequence 4000000 / 8345840
[137.861773] Sequence 5000000 / 8345840
[150.269072] Sequence 6000000 / 8345840
[156.359194] Sequence 7000000 / 8345840
[163.272485] Sequence 8000000 / 8345840
[165.215304] Adjusting marker info...
[168.458947] Connecting preNodes
[171.305269] Connecting 1000000 / 8345840
[173.903067] Connecting 2000000 / 8345840
[176.615389] Connecting 3000000 / 8345840
[179.212469] Connecting 4000000 / 8345840
[182.996073] Connecting 5000000 / 8345840
[186.348296] Connecting 6000000 / 8345840
[189.583665] Connecting 7000000 / 8345840
[193.485941] Connecting 8000000 / 8345840
[194.240058] Cleaning up memory
[194.241795] Done creating preGraph
[194.241823] Concatenation...
[196.115044] Renumbering preNodes
[196.116174] Initial preNode count 4475261
[196.456396] Destroyed 3425364 preNodes
[196.456419] Concatenation over!
[196.456421] Clipping short tips off preGraph
[197.372460] Concatenation...
[197.947001] Renumbering preNodes
[197.947048] Initial preNode count 1049897
[198.047541] Destroyed 858410 preNodes
[198.047577] Concatenation over!
[198.047579] 477817 tips cut off
[198.047581] 191487 nodes left
[198.051754] Writing into pregraph file G04870_55/PreGraph...
[201.325583] Reading read set file G04870_55/Sequences;
[236.706494] 8345840 sequences found
[322.727000] Done
[333.526458] Reading pre-graph file G04870_55/PreGraph
[333.597801] Graph has 191487 nodes and 8345840 sequences
[334.778052] Scanning pre-graph file G04870_55/PreGraph for k-mers
[335.447811] 7562503 kmers found
[336.653184] Sorting kmer occurence table ... 
[343.332423] Sorting done.
[343.332451] Computing acceleration table... 
[343.437116] Computing offsets... 
[343.490196] Ghost Threading through reads 0 / 8345840
[376.651942] Ghost Threading through reads 1000000 / 8345840
[411.678503] Ghost Threading through reads 2000000 / 8345840
[448.983814] Ghost Threading through reads 3000000 / 8345840
[480.403796] Ghost Threading through reads 4000000 / 8345840
[513.425619] Ghost Threading through reads 5000000 / 8345840
[537.394700] Ghost Threading through reads 6000000 / 8345840
[554.835206] Ghost Threading through reads 7000000 / 8345840
[572.484758] Ghost Threading through reads 8000000 / 8345840
[577.877872]  === Ghost-Threaded in 234.387677 s
[577.877900] Threading through reads 0 / 8345840
[597.028325] Threading through reads 1000000 / 8345840
[616.426857] Threading through reads 2000000 / 8345840
[635.890827] Threading through reads 3000000 / 8345840
[656.111446] Threading through reads 4000000 / 8345840
[674.273669] Threading through reads 5000000 / 8345840
[693.091170] Threading through reads 6000000 / 8345840
[711.489920] Threading through reads 7000000 / 8345840
[730.109635] Threading through reads 8000000 / 8345840
[735.919837]  === Threaded in 158.041937 s
[736.353075] Correcting graph with cutoff 0.200000
[736.360060] Determining eligible starting points
[736.599004] Done listing starting nodes
[736.599025] Initializing todo lists
[736.647894] Done with initilization
[736.647919] Activating arc lookup table
[736.750370] Done activating arc lookup table
[736.777214] 10000 / 191487 nodes visited
[736.802011] 20000 / 191487 nodes visited
[736.822974] 30000 / 191487 nodes visited
[736.845292] 40000 / 191487 nodes visited
[736.872429] 50000 / 191487 nodes visited
[736.931844] 60000 / 191487 nodes visited
[737.000060] 70000 / 191487 nodes visited
[737.061514] 80000 / 191487 nodes visited
[737.116325] 90000 / 191487 nodes visited
[737.206253] 100000 / 191487 nodes visited
[737.277083] 110000 / 191487 nodes visited
[737.348881] 120000 / 191487 nodes visited
[737.424537] 130000 / 191487 nodes visited
[737.495415] 140000 / 191487 nodes visited
[737.567074] 150000 / 191487 nodes visited
[737.649640] 160000 / 191487 nodes visited
[737.736656] 170000 / 191487 nodes visited
[737.830393] 180000 / 191487 nodes visited
[737.937565] 190000 / 191487 nodes visited
[738.042497] 200000 / 191487 nodes visited
[738.143739] 210000 / 191487 nodes visited
[738.257771] 220000 / 191487 nodes visited
[738.389555] 230000 / 191487 nodes visited
[738.552242] 240000 / 191487 nodes visited
[738.714706] 250000 / 191487 nodes visited
[738.891443] 260000 / 191487 nodes visited
[739.083187] 270000 / 191487 nodes visited
[739.273023] 280000 / 191487 nodes visited
[739.468658] 290000 / 191487 nodes visited
[739.631253] 300000 / 191487 nodes visited
[739.647586] 310000 / 191487 nodes visited
[739.668057] 320000 / 191487 nodes visited
[739.678329] Concatenation...
[739.706566] Renumbering nodes
[739.706585] Initial node count 191487
[739.714271] Removed 6083 null nodes
[739.714300] Concatenation over!
[739.714303] Clipping short tips off graph, drastic
[740.001031] Concatenation...
[740.700395] Renumbering nodes
[740.700415] Initial node count 185404
[740.702298] Removed 168382 null nodes
[740.702315] Concatenation over!
[740.702318] 17022 nodes left
[740.704807] Writing into graph file G04870_55/Graph2...
[744.686271] Measuring median coverage depth...
[744.693319] Median coverage depth = 76.570191
[744.694430] Removing contigs with coverage < 38.285095...
[744.710021] Concatenation...
[746.211887] Renumbering nodes
[746.211914] Initial node count 17022
[746.212000] Removed 16292 null nodes
[746.212002] Concatenation over!
[746.212020] Concatenation...
[746.212069] Renumbering nodes
[746.212071] Initial node count 730
[746.212073] Removed 0 null nodes
[746.212074] Concatenation over!
[746.212084] Clipping short tips off graph, drastic
[746.212161] Concatenation...
[746.212349] Renumbering nodes
[746.212351] Initial node count 730
[746.212361] Removed 36 null nodes
[746.212362] Concatenation over!
[746.212363] 694 nodes left
[746.212365] Read coherency...
[746.212375] Identifying unique nodes
[746.212388] Done, 419 unique nodes counted
[746.212390] Trimming read tips
[746.212417] Renumbering nodes
[746.212419] Initial node count 694
[746.212421] Removed 0 null nodes
[746.212423] Confronted to 0 multiple hits and 0 null over 0
[746.212424] Read coherency over!
[746.243518] Starting pebble resolution...
[746.279564] Computing read to node mapping array sizes
[746.511382] Computing read to node mappings
[747.807381] Estimating library insert lengths...
[747.865227] Paired-end library 1 has length: 44, sample standard deviation: 94
[747.865248] Done
[747.865264] Computing direct node to node mappings
[748.659576] Scaffolding node 0
[749.447062]  === Nodes Scaffolded in 1.581797 s
[749.611375] Preparing to correct graph with cutoff 0.200000
[749.612169] Cleaning memory
[749.612174] Deactivating local correction settings
[749.612186] Pebble done.
[749.612188] Starting pebble resolution...
[749.641048] Computing read to node mapping array sizes
[749.873545] Computing read to node mappings
[751.161325] Estimating library insert lengths...
[751.219838] Paired-end library 1 has length: 44, sample standard deviation: 94
[751.219857] Done
[751.219866] Computing direct node to node mappings
[752.053643] Scaffolding node 0
[752.850769]  === Nodes Scaffolded in 1.630900 s
[753.015146] Preparing to correct graph with cutoff 0.200000
[753.015936] Cleaning memory
[753.015941] Deactivating local correction settings
[753.015954] Pebble done.
[753.015957] Concatenation...
[753.015982] Renumbering nodes
[753.015985] Initial node count 694
[753.015987] Removed 0 null nodes
[753.015991] Concatenation over!
[753.015993] Removing reference contigs with coverage < 38.285095...
[753.016015] Concatenation...
[753.016038] Renumbering nodes
[753.016040] Initial node count 694
[753.016042] Removed 0 null nodes
[753.016045] Concatenation over!
[753.042073] Writing contigs into G04870_55/contigs.fa...
[755.341450] Writing into stats file G04870_55/stats.txt...
[755.447670] Writing into graph file G04870_55/LastGraph...
[759.166940] Estimated Coverage = 76.570191
[759.166956] Estimated Coverage cutoff = 38.285095
Final graph has 694 nodes and n50 of 23225, max 125388, total 4266631, using 7863646/8345840 reads


>>>>> assemblathon_stats <<<<<


assemblathon_stats.pl ./G04870_55/contigs.fa
assemblathon_stats.pl ./G04870_41/contigs.fa
assemblathon_stats.pl ./G04870_49/contigs.fa
assemblathon_stats.pl ./G04870_55/contigs.fa
Highest quality k_mer : 55


>>>>> abacas_align_contigs <<<<<


cd G04870_55 &&  cp ../NC000962_3.fasta ./ && abacas.pl -r ../NC000962_3.fasta -q contigs.fa -p promer -b -d -a 


>>>>> prokka_annotation <<<<<


cd ./G04870_55 && prokka --outdir ./G04870_prokka --prefix G04870 contigs.fa_NC000962_3.fasta.fasta
[16:03:49] This is prokka 1.12
[16:03:49] Written by Torsten Seemann <torsten.seemann@gmail.com>
[16:03:49] Homepage is https://github.com/tseemann/prokka
[16:03:49] Local time is Sun Dec 10 16:03:49 2017
[16:03:49] You are centos
[16:03:49] Operating system is linux
[16:03:49] You have BioPerl 1.007001
[16:03:49] System has 2 cores.
[16:03:49] Option --cpu asked for 8 cores, but system only has 2
[16:03:49] Will use maximum of 2 cores.
[16:03:49] Annotating as >>> Bacteria <<<
[16:03:49] Generating locus_tag from 'contigs.fa_NC000962_3.fasta.fasta' contents.
[16:03:49] Setting --locustag BPCPCAPB from MD5 b9c9ca9b2afaebaa438f5fd5d8b65bc8
[16:03:49] Creating new output folder: ./G04870_prokka
[16:03:49] Running: mkdir -p \.\/G04870_prokka
[16:03:49] Using filename prefix: G04870.XXX
[16:03:49] Setting HMMER_NCPU=1
[16:03:49] Writing log to: ./G04870_prokka/G04870.log
[16:03:49] Command: /opt/prokka/bin/prokka --outdir ./G04870_prokka --prefix G04870 contigs.fa_NC000962_3.fasta.fasta
[16:03:49] Appending to PATH: /opt/prokka/bin/../binaries/linux
[16:03:49] Appending to PATH: /opt/prokka/bin/../binaries/linux/../common
[16:03:49] Appending to PATH: /opt/prokka/bin
[16:03:49] Looking for 'aragorn' - found /opt/prokka/binaries/linux/aragorn
[16:03:49] Determined aragorn version is 1.2
[16:03:49] Looking for 'blastp' - found /opt/prokka/binaries/linux/blastp
[16:03:49] Determined blastp version is 2.4
[16:03:49] Looking for 'cmpress' - found /opt/prokka/binaries/linux/cmpress
[16:03:49] Determined cmpress version is 1.1
[16:03:49] Looking for 'cmscan' - found /opt/prokka/binaries/linux/cmscan
[16:03:49] Determined cmscan version is 1.1
[16:03:49] Looking for 'egrep' - found /usr/bin/egrep
[16:03:49] Looking for 'find' - found /usr/bin/find
[16:03:49] Looking for 'grep' - found /usr/bin/grep
[16:03:49] Looking for 'hmmpress' - found /opt/prokka/binaries/linux/hmmpress
[16:03:49] Determined hmmpress version is 3.1
[16:03:49] Looking for 'hmmscan' - found /opt/prokka/binaries/linux/hmmscan
[16:03:49] Determined hmmscan version is 3.1
[16:03:49] Looking for 'java' - found /usr/bin/java
[16:03:49] Looking for 'less' - found /usr/bin/less
[16:03:49] Looking for 'makeblastdb' - found /opt/prokka/binaries/linux/makeblastdb
[16:03:50] Determined makeblastdb version is 2.4
[16:03:50] Looking for 'minced' - found /opt/prokka/binaries/common/minced
[16:03:50] Determined minced version is 2.0
[16:03:50] Looking for 'parallel' - found /opt/snippy/binaries/noarch/parallel
[16:03:50] Determined parallel version is 20150122
[16:03:50] Looking for 'prodigal' - found /opt/prokka/binaries/linux/prodigal
[16:03:50] Determined prodigal version is 2.6
[16:03:50] Looking for 'prokka-genbank_to_fasta_db' - found /opt/prokka/bin/prokka-genbank_to_fasta_db
[16:03:50] Looking for 'sed' - found /usr/bin/sed
[16:03:50] Looking for 'tbl2asn' - found /opt/prokka/binaries/linux/tbl2asn
[16:03:50] Determined tbl2asn version is 25.3
[16:03:50] Using genetic code table 11.
[16:03:50] Loading and checking input file: contigs.fa_NC000962_3.fasta.fasta
[16:03:50] Wrote 1 contigs totalling 4480935 bp.
[16:03:50] Predicting tRNAs and tmRNAs
[16:03:50] Running: aragorn -l -gc11  -w \.\/G04870_prokka\/G04870\.fna
[16:03:54] 1 tRNA-Gly c[356908,356980] 33 (ccc)
[16:03:54] 2 tRNA-Tyr [630036,630119] 35 (gta)
[16:03:54] 3 tRNA-Thr [703525,703598] 34 (ggt)
[16:03:54] 4 tRNA-Met [703634,703708] 35 (cat)
[16:03:54] 5 tRNA-Trp [705555,705628] 34 (cca)
[16:03:54] 6 tRNA-Thr c[823933,824005] 33 (tgt)
[16:03:54] 7 tRNA-Lys c[897093,897166] 34 (ttt)
[16:03:54] 8 tRNA-Glu [897290,897365] 36 (ttc)
[16:03:54] 9 tRNA-Asp [897401,897477] 35 (gtc)
[16:03:54] 10 tRNA-Phe [897504,897580] 35 (gaa)
[16:03:54] 11 tRNA-Arg c[998852,998925] 34 (cct)
[16:03:54] 12 tRNA-Ala [1087335,1087410] 34 (cgc)
[16:03:54] 13 tRNA-Gln c[1111900,1111972] 34 (ttg)
[16:03:54] 14 tRNA-Leu [1151495,1151569] 35 (taa)
[16:03:54] 15 tRNA-Arg c[1422925,1422998] 34 (ccg)
[16:03:54] 16 tRNA-Leu [1489760,1489844] 35 (tag)
[16:03:54] 17 tRNA-Leu c[1558795,1558881] 32 (aag)
[16:03:54] 18 tRNA-Arg c[1604483,1604579] 37 (ccg)
[16:03:54] 19 tRNA-Leu c[1809356,1809432] 35 (caa)
[16:03:54] 20 tRNA-Pro c[1845842,1845934] 35 (ggg)
[16:03:54] 21 tRNA-Pro [1928722,1928796] 35 (ggg)
[16:03:54] 22 tRNA-Leu [2398307,2398393] 34 (gag)
[16:03:54] 23 tRNA-Val c[2507620,2507693] 33 (tac)
[16:03:54] 24 tRNA-Met c[2579075,2579149] 35 (cat)
[16:03:54] 25 tRNA-Asn c[2616932,2617005] 34 (gtt)
[16:03:54] 26 tRNA-Pro c[2763844,2763920] 35 (tgg)
[16:03:54] 27 tRNA-Gly [2764057,2764128] 33 (tcc)
[16:03:54] 28 tRNA-Arg [2791334,2791408] 35 (tct)
[16:03:54] 29 tRNA-His [2826512,2826587] 34 (gtg)
[16:03:54] 30 tRNA-Lys [2834152,2834225] 34 (ctt)
[16:03:54] 31 tRNA-Val c[2968856,2968928] 33 (cac)
[16:03:54] 32 tRNA-Gly [2969113,2969186] 34 (gcc)
[16:03:54] 33 tRNA-Cys [2969215,2969288] 33 (gca)
[16:03:54] 34 tRNA-Val [2969302,2969376] 33 (gac)
[16:03:54] 35 tRNA-Thr c[3144022,3144096] 33 (ggt)
[16:03:54] 36 tRNA-Glu c[3350717,3350790] 35 (ctc)
[16:03:54] 37 tRNA-Gln c[3350829,3350901] 34 (ctg)
[16:03:54] 38 tRNA-Ala c[3434911,3434984] 34 (ggc)
[16:03:54] 39 tmRNA c[3471117,3471483] 95,133 ADSHQRDYALAA*
[16:03:54] 40 tRNA-Met c[3563044,3563120] 35 (cat)
[16:03:54] 41 tRNA-His [3766350,3766449] 38 (gtg)
[16:03:54] 42 tRNA-Gly c[3992132,3992224] 33 (gcc)
[16:03:54] 43 tRNA-Thr c[4090101,4090176] 34 (cgt)
[16:03:54] 44 tRNA-Pro [4135280,4135355] 35 (cgg)
[16:03:54] 45 tRNA-Ser [4177075,4177163] 35 (gga)
[16:03:54] 46 tRNA-Ser c[4208235,4208324] 35 (cga)
[16:03:54] 47 tRNA-Arg c[4226124,4226197] 34 (acg)
[16:03:54] 48 tRNA-Ser c[4226227,4226316] 35 (gct)
[16:03:54] 49 tRNA-Ser c[4231840,4231927] 35 (tga)
[16:03:54] 50 tRNA-Ile [4431806,4431880] 35 (gat)
[16:03:54] 51 tRNA-Ala [4432031,4432104] 34 (tgc)
[16:03:54] 52 tRNA-Leu [4446545,4446629] 34 (cag)
[16:03:54] Found 52 tRNAs
[16:03:54] Predicting Ribosomal RNAs
[16:03:54] You need either Barrnap or RNAmmer installed to predict rRNAs!
[16:03:54] Skipping ncRNA search, enable with --rfam if desired.
[16:03:54] Total of 51 tRNA + rRNA features
[16:03:54] Searching for CRISPR repeats
[16:03:55] CRISPR1 ordered_NC000962_3 541384 with 3 spacers
[16:03:55] CRISPR2 ordered_NC000962_3 2529091 with 3 spacers
[16:03:55] CRISPR3 ordered_NC000962_3 3119397 with 28 spacers
[16:03:55] CRISPR4 ordered_NC000962_3 3122223 with 4 spacers
[16:03:55] CRISPR5 ordered_NC000962_3 3122986 with 15 spacers
[16:03:55] Found 5 CRISPRs
[16:03:55] Predicting coding sequences
[16:03:55] Contigs total 4480935 bp, so using single mode
[16:03:55] Running: prodigal -i \.\/G04870_prokka\/G04870\.fna -c -m -g 11 -p single -f sco -q
[16:04:04] Excluding CDS which overlaps existing RNA (tRNA) at ordered_NC000962_3:897326..897493 on - strand
[16:04:05] Excluding CDS which overlaps existing RNA (tRNA) at ordered_NC000962_3:1558623..1559447 on - strand
[16:04:05] Excluding CDS which overlaps existing RNA (tRNA) at ordered_NC000962_3:1604437..1605558 on - strand
[16:04:05] Excluding CDS which overlaps existing RNA (tRNA) at ordered_NC000962_3:1843978..1846251 on - strand
[16:04:07] Excluding CDS which overlaps existing RNA (repeat_region) at ordered_NC000962_3:3119517..3119753 on - strand
[16:04:07] Excluding CDS which overlaps existing RNA (repeat_region) at ordered_NC000962_3:3120264..3120500 on - strand
[16:04:07] Excluding CDS which overlaps existing RNA (repeat_region) at ordered_NC000962_3:3120644..3121285 on - strand
[16:04:07] Excluding CDS which overlaps existing RNA (repeat_region) at ordered_NC000962_3:3123099..3123995 on - strand
[16:04:07] Excluding CDS which overlaps existing RNA (tRNA) at ordered_NC000962_3:3143089..3144399 on - strand
[16:04:07] Excluding CDS which overlaps existing RNA (tRNA) at ordered_NC000962_3:3766337..3766477 on + strand
[16:04:07] Excluding CDS which overlaps existing RNA (tRNA) at ordered_NC000962_3:3991283..3992302 on - strand
[16:04:08] Excluding CDS which overlaps existing RNA (tRNA) at ordered_NC000962_3:4432042..4432260 on - strand
[16:04:08] Excluding CDS which overlaps existing RNA (tRNA) at ordered_NC000962_3:4446587..4446916 on + strand
[16:04:08] Found 4249 CDS
[16:04:08] Connecting features back to sequences
[16:04:08] Not using genus-specific database. Try --usegenus to enable it.
[16:04:08] Annotating CDS, please be patient.
[16:04:08] Will use 2 CPUs for similarity searching.
[16:04:13] There are still 4249 unannotated CDS left (started with 4249)
[16:04:13] Will use blast to search against /opt/prokka/bin/../db/kingdom/Bacteria/sprot with 2 CPUs
[16:04:13] Running: cat \.\/G04870_prokka\/sprot\.faa | parallel --gnu --plain -j 2 --block 322199 --recstart '>' --pipe blastp -query - -db /opt/prokka/bin/../db/kingdom/Bacteria/sprot -evalue 1e-06 -num_threads 1 -num_descriptions 1 -num_alignments 1 -seg no > \.\/G04870_prokka\/sprot\.blast 2> /dev/null
[16:06:49] Modify product: Uncharacterized metal-dependent hydrolase TatD => putative metal-dependent hydrolase TatD
[16:06:49] Modify product: Putative ligase Rv1013 => Putative ligase
[16:06:49] Modify product: Probable sensor histidine kinase TcrY => putative sensor histidine kinase TcrY
[16:06:49] Modify product: Probable transcriptional regulatory protein TcrX => putative transcriptional regulatory protein TcrX
[16:06:49] Modify product: Uncharacterized PE family protein PE23 => putative PE family protein PE23
[16:06:49] Modify product: Uncharacterized NTE family protein Rv1063c => putative NTE family protein
[16:06:49] Modify product: Probable enoyl-CoA hydratase echA8 => putative enoyl-CoA hydratase echA8
[16:06:49] Modify product: Putative cystathionine beta-synthase Rv1077 => Putative cystathionine beta-synthase
[16:06:49] Modify product: Proline-rich antigen homolog => Proline-rich antigen 
[16:06:49] Modify product: Uncharacterized PE-PGRS family protein PE_PGRS24 => putative PE-PGRS family protein PE_PGRS24
[16:06:49] Modify product: Uncharacterized PPE family protein PPE40 => putative PPE family protein PPE40
[16:06:49] Modify product: Uncharacterized oxidoreductase Rv1144 => putative oxidoreductase
[16:06:49] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv0830 => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:49] Modify product: Probable monoacyl phosphatidylinositol tetramannoside-binding protein LpqW => putative monoacyl phosphatidylinositol tetramannoside-binding protein LpqW
[16:06:49] Modify product: Uncharacterized HTH-type transcriptional regulator Rv1556 => putative HTH-type transcriptional regulator
[16:06:49] Modify product: Uncharacterized PPE family protein PPE17 => putative PPE family protein PPE17
[16:06:49] Modify product: Probable ECF RNA polymerase sigma factor SigI => putative ECF RNA polymerase sigma factor SigI
[16:06:49] Modify product: Putative O-methyltransferase Rv1220c => Putative O-methyltransferase
[16:06:49] Modify product: Uncharacterized HTH-type transcriptional regulator Rv1255c => putative HTH-type transcriptional regulator
[16:06:49] Modify product: Uncharacterized FAD-linked oxidoreductase Rv2280 => putative FAD-linked oxidoreductase
[16:06:49] Modify product: Probable multidrug-efflux transporter Rv1258c => putative multidrug-efflux transporter
[16:06:49] Modify product: F420H(2)-dependent quinone reductase Rv1261c => F420H(2)-dependent quinone reductase
[16:06:49] Modify product: Uncharacterized HIT-like protein HP_0404 => putative HIT-like protein
[16:06:49] Modify product: pH-sensitive adenylate cyclase Rv1264 => pH-sensitive adenylate cyclase
[16:06:49] Modify product: Uncharacterized ABC transporter ATP-binding protein Rv1272c => putative ABC transporter ATP-binding protein
[16:06:49] Modify product: Uncharacterized ABC transporter ATP-binding protein Rv1273c => putative ABC transporter ATP-binding protein
[16:06:49] Modify product: Uncharacterized GMC-type oxidoreductase Rv1279 => putative GMC-type oxidoreductase
[16:06:49] Modify product: Probable monoacyl phosphatidylinositol tetramannoside-binding protein LpqW => putative monoacyl phosphatidylinositol tetramannoside-binding protein LpqW
[16:06:49] Modify product: Uncharacterized ABC transporter ATP-binding protein Rv1281c => putative ABC transporter ATP-binding protein
[16:06:49] Modify product: Putative peptide transport permease protein Rv1282c => Putative peptide transport permease protein
[16:06:49] Modify product: Putative peptide transport permease protein Rv1283c => Putative peptide transport permease protein
[16:06:49] Modify product: Putative HTH-type transcriptional regulator Rv1287 => Putative HTH-type transcriptional regulator
[16:06:49] Modify product: Probable bifunctional transcriptional activator/DNA repair enzyme AlkA => putative bifunctional transcriptional activator/DNA repair enzyme AlkA
[16:06:49] Modify product: Probable acetyl-CoA acetyltransferase => putative acetyl-CoA acetyltransferase
[16:06:49] Modify product: Probable ATP-dependent helicase DinG homolog => putative ATP-dependent helicase DinG 
[16:06:49] Modify product: Uncharacterized aminopeptidase Rv1333 => putative aminopeptidase
[16:06:49] Modify product: Uncharacterized oxidoreductase Rv1350 => putative oxidoreductase
[16:06:49] Modify product: Uncharacterized signaling protein CC_0091 => putative signaling protein
[16:06:49] Modify product: Probable adenylyltransferase/sulfurtransferase MoeZ => putative adenylyltransferase/sulfurtransferase MoeZ
[16:06:49] Modify product: Uncharacterized signaling protein CC_0091 => putative signaling protein
[16:06:49] Modify product: Putative HTH-type transcriptional regulator Rv0890c => Putative HTH-type transcriptional regulator
[16:06:49] Modify product: Putative coenzyme F420-dependent oxidoreductase Rv3520c => Putative coenzyme F420-dependent oxidoreductase
[16:06:49] Modify product: Glycolipid sulfotransferase Rv1373 => Glycolipid sulfotransferase
[16:06:49] Modify product: Uncharacterized PPE family protein PPE20 => putative PPE family protein PPE20
[16:06:49] Modify product: Uncharacterized membrane protein Rv1401 => putative membrane protein
[16:06:49] Modify product: Probable primosomal protein N' => putative primosomal protein N'
[16:06:49] Modify product: Putative methyltransferase Rv1407 => Putative methyltransferase
[16:06:49] Modify product: Probable triacylglyceride transporter BCG_1471c => putative triacylglyceride transporter
[16:06:50] Modify product: Nucleotide-binding protein Rv1421 => Nucleotide-binding protein
[16:06:50] Modify product: Putative diacyglycerol O-acyltransferase Rv1425 => Putative diacyglycerol O-acyltransferase
[16:06:50] Modify product: Probable L,D-transpeptidase 3 => putative L,D-transpeptidase 3
[16:06:50] Modify product: Probable protein-export membrane protein SecG => putative protein-export membrane protein SecG
[16:06:50] Modify product: Alpha-(1->6)-mannopyranosyltransferase Rv1459c => Alpha-(1->6)-mannopyranosyltransferase
[16:06:50] Modify product: Probable cysteine desulfurase => putative cysteine desulfurase
[16:06:50] Modify product: Uncharacterized PE-PGRS family protein PE_PGRS24 => putative PE-PGRS family protein PE_PGRS24
[16:06:50] Modify product: Probable cobalt/nickel-exporting P-type ATPase => putative cobalt/nickel-exporting P-type ATPase
[16:06:50] Modify product: Probable enoyl-CoA hydratase echA12 => putative enoyl-CoA hydratase echA12
[16:06:50] Modify product: Uncharacterized ABC transporter ATP-binding protein YbiT => putative ABC transporter ATP-binding protein YbiT
[16:06:50] Modify product: Probable methylmalonyl-CoA mutase large subunit => putative methylmalonyl-CoA mutase large subunit
[16:06:50] Modify product: Probable methylmalonyl-CoA mutase small subunit => putative methylmalonyl-CoA mutase small subunit
[16:06:50] Modify product: Probable methylmalonyl-CoA mutase large subunit => putative methylmalonyl-CoA mutase large subunit
[16:06:50] Modify product: Probable antitoxin MazE4 => putative antitoxin MazE4
[16:06:50] Modify product: Probable GTPase Rv1496 => putative GTPase
[16:06:50] Modify product: Uncharacterized glycosyltransferase Rv1514c => putative glycosyltransferase
[16:06:50] Modify product: Uncharacterized glycosyltransferase Rv1524 => putative glycosyltransferase
[16:06:50] Modify product: Uncharacterized glycosyltransferase Rv1524 => putative glycosyltransferase
[16:06:50] Modify product: Probable alcohol dehydrogenase adh => putative alcohol dehydrogenase adh
[16:06:50] Modify product: Putative monooxygenase Rv1533 => Putative monooxygenase
[16:06:50] Modify product: Uncharacterized HTH-type transcriptional regulator YfiR => putative HTH-type transcriptional regulator YfiR
[16:06:50] Modify product: Probable L-asparaginase => putative L-asparaginase
[16:06:50] Modify product: Uncharacterized RNA pseudouridine synthase Rv1540 => putative RNA pseudouridine synthase
[16:06:50] Modify product: Uncharacterized oxidoreductase Rv1543 => putative oxidoreductase
[16:06:50] Modify product: Uncharacterized oxidoreductase SA2266 => putative oxidoreductase
[16:06:50] Modify product: Toxin Rv0910 => Toxin
[16:06:50] Modify product: Uncharacterized PPE family protein PPE40 => putative PPE family protein PPE40
[16:06:50] Modify product: Uncharacterized HTH-type transcriptional regulator Rv1556 => putative HTH-type transcriptional regulator
[16:06:50] Modify product: F420H(2)-dependent quinone reductase Rv1558 => F420H(2)-dependent quinone reductase
[16:06:50] Modify product: Glycogen operon protein GlgX homolog => Glycogen operon protein GlgX 
[16:06:50] Modify product: Probable inactive lipase Rv1592c => putative inactive lipase
[16:06:50] Modify product: Probable inositol 1-monophosphatase ImpA => putative inositol 1-monophosphatase ImpA
[16:06:50] Modify product: Putative peroxiredoxin Rv1608c => Putative peroxiredoxin
[16:06:50] Modify product: Probable ABC transporter ATP-binding protein HI_0664 => putative ABC transporter ATP-binding protein
[16:06:50] Modify product: Probable transcriptional regulatory protein pdtaR => putative transcriptional regulatory protein pdtaR
[16:06:50] Modify product: Probable multidrug-efflux transporter Rv1634 => putative multidrug-efflux transporter
[16:06:50] Modify product: Universal stress protein Rv1636 => Universal stress protein
[16:06:50] Modify product: pH-sensitive adenylate cyclase Rv1264 => pH-sensitive adenylate cyclase
[16:06:50] Modify product: Uncharacterized HTH-type transcriptional regulator MT0088 => putative HTH-type transcriptional regulator
[16:06:50] Modify product: HTH-type transcriptional repressor Rv3405c => HTH-type transcriptional repressor
[16:06:50] Modify product: Uncharacterized ABC transporter ATP-binding protein YbhF => putative ABC transporter ATP-binding protein YbhF
[16:06:50] Modify product: Uncharacterized PPE family protein PPE32 => putative PPE family protein PPE32
[16:06:50] Modify product: Uncharacterized RNA pseudouridine synthase Rv1711 => putative RNA pseudouridine synthase
[16:06:50] Modify product: Probable 3-hydroxybutyryl-CoA dehydrogenase => putative 3-hydroxybutyryl-CoA dehydrogenase
[16:06:50] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv1729c => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:50] Modify product: Probable membrane protein Rv1733c => putative membrane protein
[16:06:50] Modify product: Uncharacterized membrane protein MT1776 => putative membrane protein
[16:06:50] Modify product: Probable nitrate/nitrite transporter NarK2 => putative nitrate/nitrite transporter NarK2
[16:06:50] Modify product: Probable sulfate transporter Rv1739c => putative sulfate transporter
[16:06:50] Modify product: ABC transporter ATP-binding/permease protein Rv1747 => ABC transporter ATP-binding/permease protein
[16:06:50] Modify product: Probable cutinase Rv1984c => putative cutinase
[16:06:50] Modify product: Putative diacyglycerol O-acyltransferase Rv1760 => Putative diacyglycerol O-acyltransferase
[16:06:50] Modify product: Uncharacterized HTH-type transcriptional regulator Rv1255c => putative HTH-type transcriptional regulator
[16:06:50] Modify product: Uncharacterized PPE family protein PPE42 => putative PPE family protein PPE42
[16:06:50] Modify product: Uncharacterized PPE family protein PPE29 => putative PPE family protein PPE29
[16:06:50] Modify product: Uncharacterized PPE family protein PPE33 => putative PPE family protein PPE33
[16:06:50] Modify product: Uncharacterized PPE family protein PPE29 => putative PPE family protein PPE29
[16:06:50] Modify product: Uncharacterized PPE family protein PPE32 => putative PPE family protein PPE32
[16:06:50] Modify product: Uncharacterized PPE family protein PPE33 => putative PPE family protein PPE33
[16:06:50] Modify product: NADH dehydrogenase-like protein MT1860 => NADH dehydrogenase-like protein
[16:06:50] Modify product: Uncharacterized HTH-type transcriptional regulator Rv1816 => putative HTH-type transcriptional regulator
[16:06:51] Modify product: Uncharacterized HTH-type transcriptional regulator Rv1828 => putative HTH-type transcriptional regulator
[16:06:51] Modify product: Uncharacterized HTH-type transcriptional regulator Rv1830 => putative HTH-type transcriptional regulator
[16:06:51] Modify product: Probable glycine dehydrogenase (decarboxylating) => putative glycine dehydrogenase (decarboxylating)
[16:06:51] Modify product: Putative serine esterase Rv1835c => Putative serine esterase
[16:06:51] Modify product: Uncharacterized oxidoreductase Rv1843c => putative oxidoreductase
[16:06:51] Modify product: Putative esterase Rv1847 => Putative esterase
[16:06:51] Modify product: NADH dehydrogenase-like protein SA0802 => NADH dehydrogenase-like protein
[16:06:51] Modify product: Putative oxidoreductase Rv1856c => Putative oxidoreductase
[16:06:51] Modify product: Probable alcohol dehydrogenase AdhA => putative alcohol dehydrogenase AdhA
[16:06:51] Modify product: Probable oxidoreductase EphD => putative oxidoreductase EphD
[16:06:51] Modify product: Probable CoA-transferase Rv1866 => putative CoA-transferase
[16:06:51] Modify product: Probable lipoprotein LppE => putative lipoprotein LppE
[16:06:51] Modify product: Uncharacterized oxidoreductase SA2266 => putative oxidoreductase
[16:06:51] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv3787c => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:51] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv3399 => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:51] Modify product: Putative monooxygenase Rv1533 => Putative monooxygenase
[16:06:51] Modify product: Putative monooxygenase Rv1533 => Putative monooxygenase
[16:06:51] Modify product: Probable zinc-binding alcohol dehydrogenase Rv1895 => putative zinc-binding alcohol dehydrogenase
[16:06:51] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv1896c => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:51] Modify product: Probable D-amino-acid oxidase => putative D-amino-acid oxidase
[16:06:51] Modify product: HTH-type transcriptional regulator Rv1931c => HTH-type transcriptional regulator
[16:06:51] Modify product: Probable thiol peroxidase => putative thiol peroxidase
[16:06:51] Modify product: Probable endoribonuclease MazF5 => putative endoribonuclease MazF5
[16:06:51] Modify product: Probable endoribonuclease HigB1 => putative endoribonuclease HigB1
[16:06:51] Modify product: SecB-like chaperone Rv1957 => SecB-like chaperone
[16:06:51] Modify product: Probable phospholipid ABC transporter permease protein MlaE => putative phospholipid ABC transporter permease protein MlaE
[16:06:51] Modify product: Probable phospholipid ABC transporter permease protein MlaE => putative phospholipid ABC transporter permease protein MlaE
[16:06:51] Modify product: Probable phospholipid ABC transporter-binding protein MlaD => putative phospholipid ABC transporter-binding protein MlaD
[16:06:51] Modify product: Uncharacterized transporter Rv1979c => putative transporter
[16:06:51] Modify product: Probable cutinase Rv1984c => putative cutinase
[16:06:51] Modify product: Uncharacterized HTH-type transcriptional regulator Rv1985c => putative HTH-type transcriptional regulator
[16:06:51] Modify product: Putative short-chain type dehydrogenase/reductase MSMEG_6031/MSMEI_5872 => Putative short-chain type dehydrogenase/reductase/MSMEI_5872
[16:06:51] Modify product: Putative ligase Rv1013 => Putative ligase
[16:06:51] Modify product: Uncharacterized MFS-type transporter Rv0037c => putative MFS-type transporter
[16:06:51] Modify product: Uncharacterized HTH-type transcriptional regulator Rv0880 => putative HTH-type transcriptional regulator
[16:06:51] Modify product: Uncharacterized HTH-type transcriptional regulator Rv0043c => putative HTH-type transcriptional regulator
[16:06:51] Modify product: Putative coenzyme F420-dependent oxidoreductase Rv3520c => Putative coenzyme F420-dependent oxidoreductase
[16:06:51] Modify product: Uncharacterized FAD-linked oxidoreductase YvdP => putative FAD-linked oxidoreductase YvdP
[16:06:51] Modify product: Uncharacterized ABC transporter permease Rv0072 => putative ABC transporter permease
[16:06:51] Modify product: Uncharacterized ABC transporter ATP-binding protein Rv0073 => putative ABC transporter ATP-binding protein
[16:06:51] Modify product: Uncharacterized HTH-type transcriptional regulator MT0088 => putative HTH-type transcriptional regulator
[16:06:51] Modify product: Uncharacterized PPE family protein PPE2 => putative PPE family protein PPE2
[16:06:51] Modify product: Putative dioxygenase Rv0097 => Putative dioxygenase
[16:06:51] Modify product: Uncharacterized NTE family protein Rv2565 => putative NTE family protein
[16:06:51] Modify product: Probable cation-transporting ATPase I => putative cation-transporting ATPase I
[16:06:51] Modify product: Probable hydrogen peroxide-inducible genes activator => putative hydrogen peroxide-inducible genes activator
[16:06:51] Modify product: Probable sulfoacetate--CoA ligase => putative sulfoacetate--CoA ligase
[16:06:51] Modify product: Probable enoyl-CoA hydratase 1 => putative enoyl-CoA hydratase 1
[16:06:51] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv0145 => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:51] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv0146 => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:51] Modify product: Putative short-chain type dehydrogenase/reductase Rv0148 => Putative short-chain type dehydrogenase/reductase
[16:06:51] Modify product: Uncharacterized PE-PGRS family protein PE_PGRS24 => putative PE-PGRS family protein PE_PGRS24
[16:06:51] Modify product: Uncharacterized FAD-linked oxidoreductase Rv2280 => putative FAD-linked oxidoreductase
[16:06:51] Modify product: Probable phospholipid ABC transporter permease protein MlaE => putative phospholipid ABC transporter permease protein MlaE
[16:06:51] Modify product: Probable phospholipid ABC transporter permease protein MlaE => putative phospholipid ABC transporter permease protein MlaE
[16:06:51] Modify product: Proline-rich antigen homolog => Proline-rich antigen 
[16:06:51] Modify product: Putative quercetin 2,3-dioxygenase Rv0181c => Putative quercetin 2,3-dioxygenase
[16:06:51] Modify product: Putative O-methyltransferase Rv1220c => Putative O-methyltransferase
[16:06:51] Modify product: Multidrug efflux ATP-binding/permease protein Rv0194 => Multidrug efflux ATP-binding/permease protein
[16:06:51] Modify product: Uncharacterized HTH-type transcriptional regulator Rv0196 => putative HTH-type transcriptional regulator
[16:06:51] Modify product: Heme-binding protein Rv0203 => Heme-binding protein
[16:06:52] Modify product: Putative diacyglycerol O-acyltransferase Rv0221 => Putative diacyglycerol O-acyltransferase
[16:06:52] Modify product: Putative diacyglycerol O-acyltransferase Rv0221 => Putative diacyglycerol O-acyltransferase
[16:06:52] Modify product: Uncharacterized methyltransferase Rv0224c => putative methyltransferase
[16:06:52] Modify product: Putative secreted protein Rv0236.1 => Putative secreted protein.1
[16:06:52] Modify product: Uncharacterized PPE family protein PPE3 => putative PPE family protein PPE3
[16:06:52] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv0281 => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:52] Modify product: Probable trans-aconitate 2-methyltransferase => putative trans-aconitate 2-methyltransferase
[16:06:52] Modify product: Antitoxin Rv0298 => Antitoxin
[16:06:52] Modify product: Toxin Rv0299 => Toxin
[16:06:52] Modify product: Probable aspartate aminotransferase => putative aspartate aminotransferase
[16:06:52] Modify product: Uncharacterized membrane protein Rv0364 => putative membrane protein
[16:06:52] Modify product: Probable xanthine dehydrogenase subunit A => putative xanthine dehydrogenase subunit A
[16:06:52] Modify product: Uncharacterized HTH-type transcriptional regulator Rv0377 => putative HTH-type transcriptional regulator
[16:06:52] Modify product: Putative HTH-type transcriptional regulator Rv0890c => Putative HTH-type transcriptional regulator
[16:06:52] Modify product: Uncharacterized PPE family protein PPE32 => putative PPE family protein PPE32
[16:06:52] Modify product: NADH dehydrogenase-like protein SA0802 => NADH dehydrogenase-like protein
[16:06:52] Modify product: Probable transport protein MmpL1 => putative transport protein MmpL1
[16:06:52] Modify product: Probable metallo-hydrolase YflN => putative metallo-hydrolase YflN
[16:06:52] Modify product: Probable lipoprotein aminopeptidase LpqL => putative lipoprotein aminopeptidase LpqL
[16:06:52] Modify product: Probable cation-transporting ATPase I => putative cation-transporting ATPase I
[16:06:52] Modify product: Uncharacterized oxidoreductase Rv0769 => putative oxidoreductase
[16:06:52] Modify product: Uncharacterized PPE family protein PPE10 => putative PPE family protein PPE10
[16:06:52] Modify product: Probable aldehyde dehydrogenase => putative aldehyde dehydrogenase
[16:06:52] Modify product: Uncharacterized HTH-type transcriptional regulator Rv0472c => putative HTH-type transcriptional regulator
[16:06:52] Modify product: Uncharacterized HTH-type transcriptional regulator Rv0474 => putative HTH-type transcriptional regulator
[16:06:52] Modify product: Hydrolase Rv0480c => Hydrolase
[16:06:52] Modify product: Uncharacterized oxidoreductase Rv0484c => putative oxidoreductase
[16:06:52] Modify product: Transcriptional regulator Rv0485 => Transcriptional regulator
[16:06:52] Modify product: Uncharacterized GMC-type oxidoreductase Rv0492c => putative GMC-type oxidoreductase
[16:06:52] Modify product: Uncharacterized HTH-type transcriptional regulator Rv0494 => putative HTH-type transcriptional regulator
[16:06:52] Modify product: Putative DNA-binding protein Rv0500A => Putative DNA-binding proteinA
[16:06:52] Modify product: Probable transport accessory protein MmpS2 => putative transport accessory protein MmpS2
[16:06:52] Modify product: Probable transport protein MmpL2 => putative transport protein MmpL2
[16:06:52] Modify product: Uncharacterized glycosyltransferase Rv0539 => putative glycosyltransferase
[16:06:52] Modify product: Probable 2-succinylbenzoate--CoA ligase => putative 2-succinylbenzoate--CoA ligase
[16:06:52] Modify product: Protease HtpX homolog => Protease HtpX 
[16:06:52] Modify product: Probable glycerol-3-phosphate dehydrogenase 2 [NAD(P)+] => putative glycerol-3-phosphate dehydrogenase 2 [NAD(P)+]
[16:06:52] Modify product: Putative phosphoribosyl transferase MT0597 => Putative phosphoribosyl transferase
[16:06:52] Modify product: Probable polyglutamine synthesis accessory protein MT0602 => putative polyglutamine synthesis accessory protein
[16:06:52] Modify product: HTH-type transcriptional regulator Rv2034 => HTH-type transcriptional regulator
[16:06:52] Modify product: Probable phospholipid ABC transporter permease protein MlaE => putative phospholipid ABC transporter permease protein MlaE
[16:06:52] Modify product: Probable phospholipid ABC transporter permease protein MlaE => putative phospholipid ABC transporter permease protein MlaE
[16:06:52] Modify product: TVP38/TMEM64 family membrane protein Rv0625c => TVP38/TMEM64 family membrane protein
[16:06:52] Modify product: Probable enoyl-CoA hydratase echA17 => putative enoyl-CoA hydratase echA17
[16:06:52] Modify product: Probable polyketide biosynthesis zinc-dependent hydrolase BaeB => putative polyketide biosynthesis zinc-dependent hydrolase BaeB
[16:06:53] Modify product: Probable protein kinase UbiB => putative protein kinase UbiB
[16:06:53] Modify product: Probable ribonucleotide transport ATP-binding protein mkl => putative ribonucleotide transport ATP-binding protein mkl
[16:06:53] Modify product: Probable endoribonuclease MazF2 => putative endoribonuclease MazF2
[16:06:53] Modify product: Probable endonuclease 4 => putative endonuclease 4
[16:06:53] Modify product: Uncharacterized NAD-dependent oxidoreductase Rv0687 => putative NAD-dependent oxidoreductase
[16:06:53] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv1729c => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:53] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv0726c => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:53] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv0731c => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:53] Modify product: Probable 3-hydroxyisobutyrate dehydrogenase => putative 3-hydroxyisobutyrate dehydrogenase
[16:06:53] Modify product: Probable 3-hydroxyisobutyrate dehydrogenase => putative 3-hydroxyisobutyrate dehydrogenase
[16:06:53] Modify product: Uncharacterized PPE family protein PPE40 => putative PPE family protein PPE40
[16:06:53] Modify product: Probable transcriptional regulatory protein TcrX => putative transcriptional regulatory protein TcrX
[16:06:53] Modify product: Probable sensor histidine kinase TcrY => putative sensor histidine kinase TcrY
[16:06:53] Modify product: Uncharacterized HIT-like protein Rv0759c => putative HIT-like protein
[16:06:53] Modify product: Uncharacterized HTH-type transcriptional regulator Rv0767c => putative HTH-type transcriptional regulator
[16:06:53] Modify product: Putative aldehyde dehydrogenase SAV2122 => Putative aldehyde dehydrogenase
[16:06:53] Modify product: Uncharacterized oxidoreductase Rv0769 => putative oxidoreductase
[16:06:53] Modify product: Uncharacterized oxidoreductase Rv0770 => putative oxidoreductase
[16:06:53] Modify product: Probable transport protein HsrA => putative transport protein HsrA
[16:06:53] Modify product: KsdD-like steroid dehydrogenase Rv0785 => KsdD-like steroid dehydrogenase
[16:06:53] Modify product: Putative monooxygenase Rv0793 => Putative monooxygenase
[16:06:53] Modify product: Probable deferrochelatase/peroxidase YfeX => putative deferrochelatase/peroxidase YfeX
[16:06:53] Modify product: Probable M18 family aminopeptidase 2 => putative M18 family aminopeptidase 2
[16:06:53] Modify product: Putative succinyl-CoA transferase Rv0802c => Putative succinyl-CoA transferase
[16:06:53] Modify product: Phosphate-specific transport system accessory protein PhoU homolog 2 => Phosphate-specific transport system accessory protein PhoU 
[16:06:53] Modify product: Probable tRNA-dihydrouridine synthase => putative tRNA-dihydrouridine synthase
[16:06:53] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv0830 => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:53] Modify product: Probable transcriptional regulatory protein NarL => putative transcriptional regulatory protein NarL
[16:06:53] Modify product: Probable sensor histidine kinase NarS => putative sensor histidine kinase NarS
[16:06:53] Modify product: Probable siderophore biosynthesis protein SbnA => putative siderophore biosynthesis protein SbnA
[16:06:53] Modify product: Probable N-succinyldiaminopimelate aminotransferase DapC => putative N-succinyldiaminopimelate aminotransferase DapC
[16:06:53] Modify product: Putative acyltransferase Rv0859 => Putative acyltransferase
[16:06:53] Modify product: Probable acyl-CoA dehydrogenase FadE10 => putative acyl-CoA dehydrogenase FadE10
[16:06:53] Modify product: Uncharacterized PPE family protein PPE40 => putative PPE family protein PPE40
[16:06:53] Modify product: Uncharacterized HTH-type transcriptional regulator Rv0880 => putative HTH-type transcriptional regulator
[16:06:53] Modify product: Probable ferredoxin/ferredoxin--NADP reductase => putative ferredoxin/ferredoxin--NADP reductase
[16:06:53] Modify product: Putative HTH-type transcriptional regulator Rv0890c => Putative HTH-type transcriptional regulator
[16:06:53] Modify product: Uncharacterized monooxygenase Rv0892 => putative monooxygenase
[16:06:53] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv0893c => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:53] Modify product: Putative HTH-type transcriptional regulator Rv0890c => Putative HTH-type transcriptional regulator
[16:06:53] Modify product: Putative diacyglycerol O-acyltransferase Rv0895 => Putative diacyglycerol O-acyltransferase
[16:06:53] Modify product: Uncharacterized membrane protein ArfB => putative membrane protein ArfB
[16:06:53] Modify product: Uncharacterized membrane protein ArfC => putative membrane protein ArfC
[16:06:53] Modify product: Probable enoyl-CoA hydratase echA6 => putative enoyl-CoA hydratase echA6
[16:06:53] Modify product: Probable cation-transporting ATPase E => putative cation-transporting ATPase E
[16:06:53] Modify product: Antitoxin Rv0909 => Antitoxin
[16:06:53] Modify product: Toxin Rv0910 => Toxin
[16:06:53] Modify product: Uncharacterized PPE family protein PPE29 => putative PPE family protein PPE29
[16:06:53] Modify product: Uncharacterized oxidoreductase Rv0927c => putative oxidoreductase
[16:06:53] Modify product: Uncharacterized formamidopyrimidine-DNA glycosylase-like protein => putative formamidopyrimidine-DNA glycosylase-like protein
[16:06:53] Modify product: Uncharacterized oxidoreductase Rv0945 => putative oxidoreductase
[16:06:53] Modify product: 34 kDa antigenic protein homolog => 34 kDa antigenic protein 
[16:06:53] Modify product: Probable copper-exporting P-type ATPase V => putative copper-exporting P-type ATPase V
[16:06:53] Modify product: Probable enoyl-CoA hydratase => putative enoyl-CoA hydratase
[16:06:53] Modify product: Probable propionyl-CoA carboxylase beta chain 5 => putative propionyl-CoA carboxylase beta chain 5
[16:06:53] Modify product: Uncharacterized ABC transporter ATP-binding protein Rv0986 => putative ABC transporter ATP-binding protein
[16:06:53] Modify product: Probable dolichyl-phosphate-mannose--protein mannosyltransferase => putative dolichyl-phosphate-mannose--protein mannosyltransferase
[16:06:53] Modify product: Probable cation-transporting ATPase G => putative cation-transporting ATPase G
[16:06:53] Modify product: Universal stress protein Rv1996 => Universal stress protein
[16:06:53] Modify product: Probable cation-transporting ATPase F => putative cation-transporting ATPase F
[16:06:53] Modify product: Uncharacterized transporter Rv1999c => putative transporter
[16:06:53] Modify product: Universal stress protein MT2061 => Universal stress protein
[16:06:53] Modify product: Uncharacterized glycosyl hydrolase MT2062 => putative glycosyl hydrolase
[16:06:53] Modify product: Probable cation efflux system protein Rv2025c => putative cation efflux system protein
[16:06:53] Modify product: Universal stress protein Rv2026c => Universal stress protein
[16:06:53] Modify product: Universal stress protein MT2087 => Universal stress protein
[16:06:53] Modify product: Putative phosphoribosyl transferase MT0597 => Putative phosphoribosyl transferase
[16:06:54] Modify product: HTH-type transcriptional regulator Rv2034 => HTH-type transcriptional regulator
[16:06:54] Modify product: Probable endoribonuclease MazF7 => putative endoribonuclease MazF7
[16:06:54] Modify product: Uncharacterized oxidoreductase Rv2073c => putative oxidoreductase
[16:06:54] Modify product: Probable dipeptidase PepE => putative dipeptidase PepE
[16:06:54] Modify product: Probable helicase HelY => putative helicase HelY
[16:06:54] Modify product: Uncharacterized PPE family protein PPE36 => putative PPE family protein PPE36
[16:06:54] Modify product: Uncharacterized PPE family protein PPE37 => putative PPE family protein PPE37
[16:06:54] Modify product: Uncharacterized NAD-dependent oxidoreductase MAP_4146 => putative NAD-dependent oxidoreductase
[16:06:54] Modify product: Putative phosphoribosyl transferase MT0597 => Putative phosphoribosyl transferase
[16:06:54] Modify product: Laccase domain protein Rv2149c => Laccase domain protein
[16:06:54] Modify product: Probable peptidoglycan glycosyltransferase FtsW => putative peptidoglycan glycosyltransferase FtsW
[16:06:54] Modify product: DNA-binding protein Rv2175c => DNA-binding protein
[16:06:54] Modify product: 3'-5' exoribonuclease MT2234.1 => 3'-5' exoribonuclease.1
[16:06:54] Modify product: Probable endopeptidase cgR_2070 => putative endopeptidase
[16:06:54] Modify product: Probable cytochrome c oxidase subunit 3 => putative cytochrome c oxidase subunit 3
[16:06:54] Modify product: Probable transport accessory protein MmpS3 => putative transport accessory protein MmpS3
[16:06:54] Modify product: pH-sensitive adenylate cyclase Rv1264 => pH-sensitive adenylate cyclase
[16:06:54] Modify product: Probable cytosol aminopeptidase => putative cytosol aminopeptidase
[16:06:54] Modify product: Probable oxidoreductase EphD => putative oxidoreductase EphD
[16:06:54] Modify product: Epimerase family protein Rv2216 => Epimerase family protein
[16:06:54] Modify product: GTP cyclohydrolase 1 type 2 homolog => GTP cyclohydrolase 1 type 2 
[16:06:54] Modify product: Uncharacterized aminotransferase Rv2231c => putative aminotransferase
[16:06:54] Modify product: Probable low molecular weight protein-tyrosine-phosphatase => putative low molecular weight protein-tyrosine-phosphatase
[16:06:54] Modify product: Uncharacterized SURF1-like protein Rv2235 => putative SURF1-like protein
[16:06:54] Modify product: Putative peroxiredoxin Rv2238c => Putative peroxiredoxin
[16:06:54] Modify product: Probable propionyl-CoA carboxylase beta chain 6 => putative propionyl-CoA carboxylase beta chain 6
[16:06:54] Modify product: Uncharacterized HTH-type transcriptional regulator Rv2250c => putative HTH-type transcriptional regulator
[16:06:54] Modify product: Uncharacterized FAD-linked oxidoreductase Rv2280 => putative FAD-linked oxidoreductase
[16:06:54] Modify product: Uncharacterized FAD-linked oxidoreductase Rv2280 => putative FAD-linked oxidoreductase
[16:06:54] Modify product: Uncharacterized HTH-type transcriptional regulator Rv2282c => putative HTH-type transcriptional regulator
[16:06:54] Modify product: Putative diacyglycerol O-acyltransferase Rv2285 => Putative diacyglycerol O-acyltransferase
[16:06:54] Modify product: Thioredoxin-like reductase Rv2466c => Thioredoxin-like reductase
[16:06:54] Modify product: Uncharacterized Na(+)/H(+) exchanger Rv2287 => putative Na(+)/H(+) exchanger
[16:06:54] Modify product: Probable CDP-diacylglycerol pyrophosphatase => putative CDP-diacylglycerol pyrophosphatase
[16:06:54] Modify product: Uncharacterized oxidoreductase Rv2298 => putative oxidoreductase
[16:06:54] Modify product: Probable metallo-hydrolase Rv2300c => putative metallo-hydrolase
[16:06:54] Modify product: Probable cutinase cut2 => putative cutinase cut2
[16:06:54] Modify product: TVP38/TMEM64 family membrane protein Rv0625c => TVP38/TMEM64 family membrane protein
[16:06:54] Modify product: Probable ABC transporter-binding protein DR_1438 => putative ABC transporter-binding protein
[16:06:54] Modify product: Universal stress protein Rv2319c => Universal stress protein
[16:06:54] Modify product: Universal stress protein Rv2319c => Universal stress protein
[16:06:54] Modify product: Uncharacterized amino acid permease YhdG => putative amino acid permease YhdG
[16:06:54] Modify product: Uncharacterized ABC transporter ATP-binding protein Rv2326c => putative ABC transporter ATP-binding protein
[16:06:54] Modify product: Uncharacterized HTH-type transcriptional regulator Rv0880 => putative HTH-type transcriptional regulator
[16:06:54] Modify product: Uncharacterized PE family protein PE23 => putative PE family protein PE23
[16:06:54] Modify product: Probable transport protein MmpL9 => putative transport protein MmpL9
[16:06:54] Modify product: Uncharacterized PPE family protein PPE38 => putative PPE family protein PPE38
[16:06:54] Modify product: Uncharacterized PPE family protein PPE40 => putative PPE family protein PPE40
[16:06:54] Modify product: Uncharacterized PPE family protein PPE40 => putative PPE family protein PPE40
[16:06:54] Modify product: Uncharacterized PE-PGRS family protein PE_PGRS24 => putative PE-PGRS family protein PE_PGRS24
[16:06:54] Modify product: Oxygen-independent coproporphyrinogen-III oxidase-like protein Rv2388c => Oxygen-independent coproporphyrinogen-III oxidase-like protein
[16:06:54] Modify product: Probable phosphoadenosine phosphosulfate reductase => putative phosphoadenosine phosphosulfate reductase
[16:06:54] Modify product: DegV domain-containing protein Rv2417c => DegV domain-containing protein
[16:06:54] Modify product: Probable nicotinate-nucleotide adenylyltransferase => putative nicotinate-nucleotide adenylyltransferase
[16:06:54] Modify product: Probable hydrogen peroxide-inducible genes activator => putative hydrogen peroxide-inducible genes activator
[16:06:54] Modify product: Putative trans-acting enoyl reductase Rv2449c => Putative trans-acting enoyl reductase
[16:06:54] Modify product: Probable molybdenum cofactor guanylyltransferase => putative molybdenum cofactor guanylyltransferase
[16:06:54] Modify product: Uncharacterized MFS-type transporter Rv2456c => putative MFS-type transporter
[16:06:54] Modify product: Thioredoxin-like reductase Rv2466c => Thioredoxin-like reductase
[16:06:55] Modify product: Putative diacyglycerol O-acyltransferase Rv2484c => Putative diacyglycerol O-acyltransferase
[16:06:55] Modify product: Probable enoyl-CoA hydratase echA14 => putative enoyl-CoA hydratase echA14
[16:06:55] Modify product: Putative HTH-type transcriptional regulator Rv0890c => Putative HTH-type transcriptional regulator
[16:06:55] Modify product: Putative HTH-type transcriptional regulator Rv0890c => Putative HTH-type transcriptional regulator
[16:06:55] Modify product: Probable succinyl-CoA:3-ketoacid coenzyme A transferase subunit B => putative succinyl-CoA:3-ketoacid coenzyme A transferase subunit B
[16:06:55] Modify product: Probable succinyl-CoA:3-ketoacid coenzyme A transferase subunit A => putative succinyl-CoA:3-ketoacid coenzyme A transferase subunit A
[16:06:55] Modify product: Putative peroxiredoxin Rv2521 => Putative peroxiredoxin
[16:06:55] Modify product: Putative peptidoglycan hydrolase Rv2525c => Putative peptidoglycan hydrolase
[16:06:55] Modify product: N utilization substance protein B homolog => N utilization substance protein B 
[16:06:55] Modify product: Uncharacterized AAA domain-containing protein Rv2559c => putative AAA domain-containing protein
[16:06:55] Modify product: Uncharacterized ABC transporter permease Rv2563 => putative ABC transporter permease
[16:06:55] Modify product: Uncharacterized ABC transporter ATP-binding protein Rv2564 => putative ABC transporter ATP-binding protein
[16:06:55] Modify product: Uncharacterized NTE family protein Rv2565 => putative NTE family protein
[16:06:55] Modify product: Probable peptidyl-prolyl cis-trans isomerase B => putative peptidyl-prolyl cis-trans isomerase B
[16:06:55] Modify product: Uncharacterized lipoprotein Rv2585c => putative lipoprotein
[16:06:55] Modify product: Probable transcriptional regulatory protein Rv2603c => putative transcriptional regulatory protein
[16:06:55] Modify product: Uncharacterized PPE family protein PPE42 => putative PPE family protein PPE42
[16:06:55] Modify product: Universal stress protein MT2698 => Universal stress protein
[16:06:55] Modify product: Universal stress protein MT2699 => Universal stress protein
[16:06:55] Modify product: Putative uncharacterized protein MT2703 => Putative uncharacterized protein
[16:06:55] Modify product: Probable protein archease => putative protein archease
[16:06:55] Modify product: Putative O-phosphotransferase Rv2636 => Putative O-phosphotransferase
[16:06:55] Modify product: Uncharacterized membrane protein Rv2637 => putative membrane protein
[16:06:55] Modify product: Uncharacterized N-acetyltransferase Rv2669 => putative N-acetyltransferase
[16:06:55] Modify product: Putative heme-dependent peroxidase SA0544 => Putative heme-dependent peroxidase
[16:06:55] Modify product: Probable enoyl-CoA hydratase echA12 => putative enoyl-CoA hydratase echA12
[16:06:55] Modify product: Uncharacterized transporter Rv2685 => putative transporter
[16:06:55] Modify product: Uncharacterized transporter Rv2685 => putative transporter
[16:06:55] Modify product: Uncharacterized transporter Rv2685 => putative transporter
[16:06:55] Modify product: Fluoroquinolones export permease protein Rv2686c => Fluoroquinolones export permease protein
[16:06:55] Modify product: Fluoroquinolones export permease protein Rv2687c => Fluoroquinolones export permease protein
[16:06:55] Modify product: Fluoroquinolones export ATP-binding protein Rv2688c => Fluoroquinolones export ATP-binding protein
[16:06:55] Modify product: Probable soluble pyridine nucleotide transhydrogenase => putative soluble pyridine nucleotide transhydrogenase
[16:06:55] Modify product: Uncharacterized membrane protein Rv2723 => putative membrane protein
[16:06:55] Modify product: Putative monooxygenase Rv0793 => Putative monooxygenase
[16:06:55] Modify product: Uncharacterized oxidoreductase Rv2750 => putative oxidoreductase
[16:06:55] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv0830 => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:55] Modify product: Putative monooxygenase Rv1533 => Putative monooxygenase
[16:06:55] Modify product: Uncharacterized zinc protease Rv2782c => putative zinc protease
[16:06:55] Modify product: Probable enoyl-CoA hydratase echA8 => putative enoyl-CoA hydratase echA8
[16:06:55] Modify product: Uncharacterized MFS-type transporter EfpA => putative MFS-type transporter EfpA
[16:06:55] Modify product: Acetyltransferase SACOL1063 => Acetyltransferase
[16:06:55] Modify product: Probable malate:quinone oxidoreductase => putative malate:quinone oxidoreductase
[16:06:55] Modify product: Putative glutamine amidotransferase Rv2859c => Putative glutamine amidotransferase
[16:06:55] Modify product: Probable dual-specificity RNA methyltransferase RlmN => putative dual-specificity RNA methyltransferase RlmN
[16:06:55] Modify product: Uncharacterized HTH-type transcriptional regulator Rv2887 => putative HTH-type transcriptional regulator
[16:06:55] Modify product: Uncharacterized PPE family protein PPE32 => putative PPE family protein PPE32
[16:06:55] Modify product: Uncharacterized oxidoreductase Rv2900c => putative oxidoreductase
[16:06:55] Modify product: Uncharacterized HTH-type transcriptional regulator Rv2912c => putative HTH-type transcriptional regulator
[16:06:55] Modify product: Probable thioesterase TesA => putative thioesterase TesA
[16:06:55] Modify product: Probable doxorubicin resistance ABC transporter permease protein DrrC => putative doxorubicin resistance ABC transporter permease protein DrrC
[16:06:55] Modify product: PGL/p-HBAD biosynthesis glycosyltransferase Rv2957 => PGL/p-HBAD biosynthesis glycosyltransferase
[16:06:55] Modify product: PGL/p-HBAD biosynthesis glycosyltransferase Rv2958c => PGL/p-HBAD biosynthesis glycosyltransferase
[16:06:55] Modify product: Putative permease Rv2963 => Putative permease
[16:06:55] Modify product: Uncharacterized oxidoreductase Mb2996 => putative oxidoreductase
[16:06:56] Modify product: Probable 8-oxo-dGTP diphosphatase 1 => putative 8-oxo-dGTP diphosphatase 1
[16:06:56] Modify product: DNA-binding protein HU homolog => DNA-binding protein HU 
[16:06:56] Modify product: Uncharacterized MFS-type transporter Rv2994 => putative MFS-type transporter
[16:06:56] Modify product: Uncharacterized MFS-type transporter Rv2994 => putative MFS-type transporter
[16:06:56] Modify product: Probable iron export permease protein FetB => putative iron export permease protein FetB
[16:06:56] Modify product: Probable S-adenosylmethionine-dependent methyltransferase Rv3030 => putative S-adenosylmethionine-dependent methyltransferase
[16:06:56] Modify product: Probable 1,4-alpha-glucan branching enzyme Rv3031 => putative 1,4-alpha-glucan branching enzyme
[16:06:56] Modify product: Putative acetyltransferase Rv3034c => Putative acetyltransferase
[16:06:56] Modify product: Probable enoyl-CoA hydratase echA17 => putative enoyl-CoA hydratase echA17
[16:06:56] Modify product: Probable cytochrome c oxidase subunit 1 => putative cytochrome c oxidase subunit 1
[16:06:56] Modify product: Probable siderophore-binding lipoprotein YfiY => putative siderophore-binding lipoprotein YfiY
[16:06:56] Modify product: Uncharacterized HTH-type transcriptional regulator Rv0472c => putative HTH-type transcriptional regulator
[16:06:56] Modify product: Putative diacyglycerol O-acyltransferase Rv3087 => Putative diacyglycerol O-acyltransferase
[16:06:56] Modify product: Probable diacyglycerol O-acyltransferase Tgs4 => putative diacyglycerol O-acyltransferase Tgs4
[16:06:56] Modify product: Putative coenzyme F420-dependent oxidoreductase Rv3520c => Putative coenzyme F420-dependent oxidoreductase
[16:06:56] Modify product: Uncharacterized HTH-type transcriptional regulator Rv3095 => putative HTH-type transcriptional regulator
[16:06:56] Modify product: Putative toxin Rv3098A/RVBD_3098A => Putative toxinA/RVBD_3098A
[16:06:56] Modify product: Uncharacterized MscS family protein YkuT => putative MscS family protein YkuT
[16:06:56] Modify product: Uncharacterized FAD-linked oxidoreductase Rv2280 => putative FAD-linked oxidoreductase
[16:06:56] Modify product: Probable adenylyltransferase/sulfurtransferase MoeZ => putative adenylyltransferase/sulfurtransferase MoeZ
[16:06:56] Modify product: Uncharacterized PPE family protein PPE38 => putative PPE family protein PPE38
[16:06:56] Modify product: Probable diacyglycerol O-acyltransferase tgs1 => putative diacyglycerol O-acyltransferase tgs1
[16:06:56] Modify product: Putative NAD(P)H nitroreductase MT3217 => Putative NAD(P)H nitroreductase
[16:06:56] Modify product: Universal stress protein MT3220 => Universal stress protein
[16:06:56] Modify product: Uncharacterized PPE family protein PPE51 => putative PPE family protein PPE51
[16:06:56] Modify product: Uncharacterized response regulatory protein Rv3143 => putative response regulatory protein
[16:06:56] Modify product: Uncharacterized PPE family protein PPE42 => putative PPE family protein PPE42
[16:06:56] Modify product: Uncharacterized PPE family protein PPE40 => putative PPE family protein PPE40
[16:06:56] Modify product: Uncharacterized HTH-type transcriptional regulator Rv1556 => putative HTH-type transcriptional regulator
[16:06:56] Modify product: Uncharacterized oxidoreductase SA2266 => putative oxidoreductase
[16:06:56] Modify product: Probable protein kinase UbiB => putative protein kinase UbiB
[16:06:56] Modify product: Probable transcriptional regulator WhiB7 => putative transcriptional regulator WhiB7
[16:06:56] Modify product: Putative glutaredoxin Rv3198.1 => Putative glutaredoxin.1
[16:06:56] Modify product: Probable adenylyltransferase/sulfurtransferase MoeZ => putative adenylyltransferase/sulfurtransferase MoeZ
[16:06:56] Modify product: Probable transport accessory protein MmpS3 => putative transport accessory protein MmpS3
[16:06:56] Modify product: Probable sensor histidine kinase pdtaS => putative sensor histidine kinase pdtaS
[16:06:56] Modify product: Uncharacterized NAD-dependent oxidoreductase MAP_4146 => putative NAD-dependent oxidoreductase
[16:06:56] Modify product: Putative diacyglycerol O-acyltransferase Rv1760 => Putative diacyglycerol O-acyltransferase
[16:06:56] Modify product: Probable diacyglycerol O-acyltransferase tgs3 => putative diacyglycerol O-acyltransferase tgs3
[16:06:56] Modify product: Uncharacterized NTE family protein Rv2565 => putative NTE family protein
[16:06:56] Modify product: Uncharacterized HTH-type transcriptional regulator Rv1255c => putative HTH-type transcriptional regulator
[16:06:56] Modify product: Uncharacterized amino acid permease YhdG => putative amino acid permease YhdG
[16:06:56] Modify product: Probable manganese/zinc-exporting P-type ATPase => putative manganese/zinc-exporting P-type ATPase
[16:06:56] Modify product: Probable acyl-CoA dehydrogenase fadE25 => putative acyl-CoA dehydrogenase fadE25
[16:06:56] Modify product: Probable propionyl-CoA carboxylase beta chain 5 => putative propionyl-CoA carboxylase beta chain 5
[16:06:56] Modify product: Maf-like protein Rv3282 => Maf-like protein
[16:06:56] Modify product: Uncharacterized SufE-like protein Rv3284 => putative SufE-like protein
[16:06:56] Modify product: Probable L-lysine-epsilon aminotransferase => putative L-lysine-epsilon aminotransferase
[16:06:56] Modify product: Phosphate-specific transport system accessory protein PhoU homolog 1 => Phosphate-specific transport system accessory protein PhoU 
[16:06:56] Modify product: Uncharacterized hydrolase YxeP => putative hydrolase YxeP
[16:06:56] Modify product: Probable phosphomannomutase => putative phosphomannomutase
[16:06:56] Modify product: Probable aminotransferase Rv3329 => putative aminotransferase
[16:06:56] Modify product: Uncharacterized methyltransferase Rv3342 => putative methyltransferase
[16:06:56] Modify product: Bifunctional protein FolD => Bifunctional protein FolD protein
[16:06:56] Modify product: ABC transporter ATP-binding/permease protein Rv1747 => ABC transporter ATP-binding/permease protein
[16:06:56] Modify product: Serine protease inhibitor Rv3364c => Serine protease inhibitor
[16:06:56] Modify product: Putative diacyglycerol O-acyltransferase Rv3371 => Putative diacyglycerol O-acyltransferase
[16:06:57] Modify product: Phosphatase Rv3376 => Phosphatase
[16:06:57] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv3399 => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:57] Modify product: Uncharacterized glycosyl hydrolase MT2062 => putative glycosyl hydrolase
[16:06:57] Modify product: Uncharacterized glycosyl hydrolase Rv3401 => putative glycosyl hydrolase
[16:06:57] Modify product: HTH-type transcriptional repressor Rv3405c => HTH-type transcriptional repressor
[16:06:57] Modify product: Uncharacterized oxidoreductase Rv3410c => putative oxidoreductase
[16:06:57] Modify product: Probable cutinase cut3 => putative cutinase cut3
[16:06:57] Modify product: Probable cutinase cut3 => putative cutinase cut3
[16:06:57] Modify product: Uncharacterized membrane protein Rv3479 => putative membrane protein
[16:06:57] Modify product: Putative diacyglycerol O-acyltransferase Rv3480c => Putative diacyglycerol O-acyltransferase
[16:06:57] Modify product: Uncharacterized oxidoreductase Rv0769 => putative oxidoreductase
[16:06:57] Modify product: Uncharacterized membrane protein Rv3486 => putative membrane protein
[16:06:57] Modify product: Probable phospholipid ABC transporter permease protein MlaE => putative phospholipid ABC transporter permease protein MlaE
[16:06:57] Modify product: Probable phospholipid ABC transporter permease protein MlaE => putative phospholipid ABC transporter permease protein MlaE
[16:06:57] Modify product: Putative short-chain type dehydrogenase/reductase Rv0148 => Putative short-chain type dehydrogenase/reductase
[16:06:57] Modify product: Putative coenzyme F420-dependent oxidoreductase Rv3520c => Putative coenzyme F420-dependent oxidoreductase
[16:06:57] Modify product: Uncharacterized PPE family protein PPE51 => putative PPE family protein PPE51
[16:06:57] Modify product: Uncharacterized PPE family protein PPE40 => putative PPE family protein PPE40
[16:06:57] Modify product: Putative short-chain type dehydrogenase/reductase Rv0148 => Putative short-chain type dehydrogenase/reductase
[16:06:57] Modify product: Probable 2,4-dienoyl-CoA reductase => putative 2,4-dienoyl-CoA reductase
[16:06:57] Modify product: Putative CoA-transferase subunit alpha Rv3551 => Putative CoA-transferase subunit alpha
[16:06:57] Modify product: Putative CoA-transferase subunit beta Rv3552 => Putative CoA-transferase subunit beta
[16:06:57] Modify product: Uncharacterized PPE family protein PPE40 => putative PPE family protein PPE40
[16:06:57] Modify product: Uncharacterized oxidoreductase Rv1350 => putative oxidoreductase
[16:06:57] Modify product: Uncharacterized tRNA/rRNA methyltransferase Rv3579c => putative tRNA/rRNA methyltransferase
[16:06:57] Modify product: Uncharacterized PPE family protein PPE32 => putative PPE family protein PPE32
[16:06:57] Modify product: Probable adenosine monophosphate-protein transferase fic => putative adenosine monophosphate-protein transferase fic
[16:06:57] Modify product: Probable cold shock protein A => putative cold shock protein A
[16:06:57] Modify product: Uncharacterized PE-PGRS family protein PE_PGRS24 => putative PE-PGRS family protein PE_PGRS24
[16:06:57] Modify product: Apoptosis inhibitor Rv3654c => Apoptosis inhibitor
[16:06:57] Modify product: Apoptosis inhibitor Rv3655c => Apoptosis inhibitor
[16:06:57] Modify product: Putative conjugal transfer protein Rv3659c => Putative conjugal transfer protein
[16:06:57] Modify product: Probable phosphatase Rv3661 => putative phosphatase
[16:06:57] Modify product: Serine protease Rv3671c => Serine protease
[16:06:57] Modify product: Probable polyketide biosynthesis zinc-dependent hydrolase PksB => putative polyketide biosynthesis zinc-dependent hydrolase PksB
[16:06:57] Modify product: Putative ATPase Rv3679 => Putative ATPase
[16:06:57] Modify product: Probable siderophore biosynthesis protein SbnA => putative siderophore biosynthesis protein SbnA
[16:06:57] Modify product: Uncharacterized membrane protein Rv3691 => putative membrane protein
[16:06:57] Modify product: Probable hercynylcysteine sulfoxide lyase => putative hercynylcysteine sulfoxide lyase
[16:06:57] Modify product: Nucleoid-associated protein Rv3716c => Nucleoid-associated protein
[16:06:57] Modify product: N-acetylmuramoyl-L-alanine amidase Rv3717 => N-acetylmuramoyl-L-alanine amidase
[16:06:57] Modify product: Probable fatty acid methyltransferase Rv3720 => putative fatty acid methyltransferase
[16:06:57] Modify product: Putative aminotransferase MSMEG_6286/MSMEI_6121 => Putative aminotransferase/MSMEI_6121
[16:06:57] Modify product: Probable cutinase Rv1984c => putative cutinase
[16:06:57] Modify product: Uncharacterized NTE family protein Rv2565 => putative NTE family protein
[16:06:57] Modify product: Probable diacyglycerol O-acyltransferase tgs2 => putative diacyglycerol O-acyltransferase tgs2
[16:06:57] Modify product: Uncharacterized PPE family protein PPE47/PPE48 => putative PPE family protein PPE47/PPE48
[16:06:57] Modify product: Putative diacyglycerol O-acyltransferase Rv3740c => Putative diacyglycerol O-acyltransferase
[16:06:57] Modify product: Probable cation-transporting P-type ATPase J => putative cation-transporting P-type ATPase J
[16:06:57] Modify product: Uncharacterized membrane protein Rv3760 => putative membrane protein
[16:06:57] Modify product: Probable sensor histidine kinase TcrY => putative sensor histidine kinase TcrY
[16:06:57] Modify product: Probable transcriptional regulatory protein TcrX => putative transcriptional regulatory protein TcrX
[16:06:57] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv3767c => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:57] Modify product: Probable enoyl-CoA hydratase echA8 => putative enoyl-CoA hydratase echA8
[16:06:57] Modify product: Putative S-adenosyl-L-methionine-dependent methyltransferase Rv3787c => Putative S-adenosyl-L-methionine-dependent methyltransferase
[16:06:57] Modify product: Arabinogalactan biosynthesis recruiting protein Rv3789 => Arabinogalactan biosynthesis recruiting protein
[16:06:57] Modify product: Probable arabinosyltransferase C => putative arabinosyltransferase C
[16:06:57] Modify product: Probable arabinosyltransferase A => putative arabinosyltransferase A
[16:06:57] Modify product: Probable arabinosyltransferase B => putative arabinosyltransferase B
[16:06:57] Modify product: Probable propionyl-CoA carboxylase beta chain 5 => putative propionyl-CoA carboxylase beta chain 5
[16:06:57] Modify product: Putative decaprenylphosphoryl-5-phosphoribose phosphatase Rv3807c => Putative decaprenylphosphoryl-5-phosphoribose phosphatase
[16:06:58] Modify product: Putative Rieske 2Fe-2S iron-sulfur protein Rv3818 => Putative Rieske 2Fe-2S iron-sulfur protein
[16:06:58] Modify product: Probable long-chain-fatty-acid--CoA ligase FadD23 => putative long-chain-fatty-acid--CoA ligase FadD23
[16:06:58] Modify product: Probable S-adenosylmethionine-dependent methyltransferase MSMEG_2350/MSMEI_2290 => putative S-adenosylmethionine-dependent methyltransferase/MSMEI_2290
[16:06:58] Modify product: Uncharacterized membrane protein Rv3835 => putative membrane protein
[16:06:58] Modify product: Probable glycerophosphodiester phosphodiesterase 1 => putative glycerophosphodiester phosphodiesterase 1
[16:06:58] Modify product: Probable transcriptional regulator WhiB6 => putative transcriptional regulator WhiB6
[16:06:58] Modify product: Probable peptidoglycan biosynthesis protein MviN => putative peptidoglycan biosynthesis protein MviN
[16:06:58] Modify product: Probable chromosome-partitioning protein ParB => putative chromosome-partitioning protein ParB
[16:06:58] Modify product: Uncharacterized FtsW-like protein => putative FtsW-like protein
[16:06:58] Modify product: Putative monooxygenase Rv1533 => Putative monooxygenase
[16:06:58] Modify product: Uncharacterized HTH-type transcriptional regulator Rv0023 => putative HTH-type transcriptional regulator
[16:06:58] Modify product: Probable endopeptidase cgR_2070 => putative endopeptidase
[16:06:58] Modify product: Uncharacterized PPE family protein PPE32 => putative PPE family protein PPE32
[16:06:58] Modify product: Uncharacterized PPE family protein PPE47/PPE48 => putative PPE family protein PPE47/PPE48
[16:06:58] Modify product: Uncharacterized PPE family protein PPE40 => putative PPE family protein PPE40
[16:06:58] Modify product: Uncharacterized PE-PGRS family protein PE_PGRS54 => putative PE-PGRS family protein PE_PGRS54
[16:06:58] Modify product: ABC transporter ATP-binding/permease protein Rv1747 => ABC transporter ATP-binding/permease protein
[16:06:58] Cleaned 531 /product names
[16:06:58] Deleting unwanted file: ./G04870_prokka/sprot.faa
[16:06:58] Deleting unwanted file: ./G04870_prokka/sprot.blast
[16:07:00] There are still 1670 unannotated CDS left (started with 4249)
[16:07:00] Will use hmmer3 to search against /opt/prokka/bin/../db/hmm/HAMAP.hmm with 2 CPUs
[16:07:00] Running: cat \.\/G04870_prokka\/HAMAP\.hmm\.faa | parallel --gnu --plain -j 2 --block 86652 --recstart '>' --pipe hmmscan --noali --notextw --acc -E 1e-06 --cpu 1 /opt/prokka/bin/../db/hmm/HAMAP.hmm /dev/stdin > \.\/G04870_prokka\/HAMAP\.hmm\.hmmer3 2> /dev/null
[16:07:57] Modify product: Uncharacterized Nudix hydrolase NudL => putative Nudix hydrolase NudL
[16:07:57] Cleaned 1 /product names
[16:07:57] Deleting unwanted file: ./G04870_prokka/HAMAP.hmm.faa
[16:07:57] Deleting unwanted file: ./G04870_prokka/HAMAP.hmm.hmmer3
[16:07:57] Labelling remaining 1613 proteins as 'hypothetical protein'
[16:07:57] Possible /pseudo 'putative HTH-type transcriptional regulator' at ordered_NC000962_3 position 16583
[16:07:57] Possible /pseudo 'Putative S-adenosyl-L-methionine-dependent methyltransferase' at ordered_NC000962_3 position 141940
[16:07:57] Possible /pseudo 'PE family protein PE3' at ordered_NC000962_3 position 149048
[16:07:57] Possible /pseudo 'PE family protein PE3' at ordered_NC000962_3 position 158660
[16:07:57] Possible /pseudo 'putative phospholipid ABC transporter permease protein MlaE' at ordered_NC000962_3 position 167391
[16:07:57] Possible /pseudo 'Putative diacyglycerol O-acyltransferase' at ordered_NC000962_3 position 234955
[16:07:57] Possible /pseudo 'PPE family protein PPE34' at ordered_NC000962_3 position 343511
[16:07:57] Possible /pseudo 'L-asparagine permease 2' at ordered_NC000962_3 position 387347
[16:07:57] Possible /pseudo 'Carbon monoxide dehydrogenase medium chain' at ordered_NC000962_3 position 424020
[16:07:57] Possible /pseudo 'Sarcosine/dimethylglycine N-methyltransferase' at ordered_NC000962_3 position 584418
[16:07:57] Possible /pseudo 'putative phospholipid ABC transporter permease protein MlaE' at ordered_NC000962_3 position 657855
[16:07:57] Possible /pseudo 'Putative S-adenosyl-L-methionine-dependent methyltransferase' at ordered_NC000962_3 position 791561
[16:07:57] Possible /pseudo 'Para-nitrobenzyl esterase' at ordered_NC000962_3 position 1206938
[16:07:57] Possible /pseudo '1,2-epoxyphenylacetyl-CoA isomerase' at ordered_NC000962_3 position 1243782
[16:07:57] Possible /pseudo 'Nitrate reductase-like protein NarX' at ordered_NC000962_3 position 1268791
[16:07:57] Possible /pseudo 'putative ABC transporter ATP-binding protein' at ordered_NC000962_3 position 1398772
[16:07:57] Possible /pseudo 'Putative peptide transport permease protein' at ordered_NC000962_3 position 1412610
[16:07:57] Possible /pseudo 'Adenylate cyclase 2' at ordered_NC000962_3 position 1457926
[16:07:57] Possible /pseudo 'Adenylate cyclase 2' at ordered_NC000962_3 position 1459543
[16:07:57] Possible /pseudo 'Carboxylesterase NlhH' at ordered_NC000962_3 position 1553312
[16:07:57] Possible /pseudo 'Putative thioredoxin 2' at ordered_NC000962_3 position 1637002
[16:07:57] Possible /pseudo 'Putative glycosyltransferases' at ordered_NC000962_3 position 1669828
[16:07:57] Possible /pseudo 'putative glycosyltransferase' at ordered_NC000962_3 position 1697094
[16:07:57] Possible /pseudo 'putative oxidoreductase' at ordered_NC000962_3 position 1724289
[16:07:57] Possible /pseudo 'Phenolphthiocerol synthesis polyketide synthase type I Pks15/1' at ordered_NC000962_3 position 1863689
[16:07:57] Possible /pseudo 'PE-PGRS family protein PE_PGRS33' at ordered_NC000962_3 position 2044889
[16:07:57] Possible /pseudo 'Haloalkane dehalogenase 2' at ordered_NC000962_3 position 2063328
[16:07:57] Possible /pseudo 'Hemolysin C' at ordered_NC000962_3 position 2074126
[16:07:57] Possible /pseudo 'Putative S-adenosyl-L-methionine-dependent methyltransferase' at ordered_NC000962_3 position 2122090
[16:07:57] Possible /pseudo 'Putative monooxygenase' at ordered_NC000962_3 position 2124827
[16:07:57] Possible /pseudo 'Riboflavin biosynthesis protein RibBA' at ordered_NC000962_3 position 2177497
[16:07:57] Possible /pseudo 'putative phospholipid ABC transporter permease protein MlaE' at ordered_NC000962_3 position 2193232
[16:07:57] Possible /pseudo 'Lipoprotein LprN' at ordered_NC000962_3 position 2200125
[16:07:57] Possible /pseudo 'Precorrin-6A reductase' at ordered_NC000962_3 position 2323599
[16:07:57] Possible /pseudo 'Long-chain-fatty-acid--CoA ligase FadD15' at ordered_NC000962_3 position 2445243
[16:07:57] Possible /pseudo 'Universal stress protein' at ordered_NC000962_3 position 2589372
[16:07:57] Possible /pseudo 'putative PPE family protein PPE40' at ordered_NC000962_3 position 2635938
[16:07:57] Possible /pseudo 'Putative HTH-type transcriptional regulator' at ordered_NC000962_3 position 2797901
[16:07:57] Possible /pseudo 'Putative lipoprotein LppA' at ordered_NC000962_3 position 2866533
[16:07:57] Possible /pseudo 'Universal stress protein' at ordered_NC000962_3 position 2949849
[16:07:57] Possible /pseudo 'putative transporter' at ordered_NC000962_3 position 3001343
[16:07:57] Possible /pseudo 'putative transporter' at ordered_NC000962_3 position 3001967
[16:07:57] Possible /pseudo 'Fluoroquinolones export permease protein' at ordered_NC000962_3 position 3003395
[16:07:57] Possible /pseudo 'Trk system potassium uptake protein TrkA' at ordered_NC000962_3 position 3009385
[16:07:57] Possible /pseudo 'PGL/p-HBAD biosynthesis rhamnosyltransferase' at ordered_NC000962_3 position 3316124
[16:07:57] Possible /pseudo 'putative MFS-type transporter' at ordered_NC000962_3 position 3353813
[16:07:57] Possible /pseudo 'Acyl-CoA dehydrogenase' at ordered_NC000962_3 position 3509939
[16:07:57] Possible /pseudo 'Putative flavin-containing monoamine oxidase AofH' at ordered_NC000962_3 position 3542917
[16:07:57] Possible /pseudo 'putative glycosyl hydrolase' at ordered_NC000962_3 position 3825622
[16:07:57] Possible /pseudo 'putative cutinase cut3' at ordered_NC000962_3 position 3881447
[16:07:57] Possible /pseudo 'putative phospholipid ABC transporter permease protein MlaE' at ordered_NC000962_3 position 3928255
[16:07:57] Possible /pseudo 'Apoptosis inhibitor' at ordered_NC000962_3 position 4103740
[16:07:57] Possible /pseudo '1-acyl-sn-glycerol-3-phosphate acyltransferase' at ordered_NC000962_3 position 4289293
[16:07:57] Possible /pseudo '1-acyl-sn-glycerol-3-phosphate acyltransferase' at ordered_NC000962_3 position 4290052
[16:07:57] Possible /pseudo 'ESX-1 secretion-associated protein EspJ' at ordered_NC000962_3 position 4366314
[16:07:57] Possible /pseudo 'ESX-1 secretion-associated protein EspK' at ordered_NC000962_3 position 4367833
[16:07:57] Found 1656 unique /gene codes.
[16:07:57] Fixed 2 duplicate /gene - dapE_1 dapE_2
[16:07:57] Fixed 4 duplicate /gene - fgd2_1 fgd2_2 fgd2_3 fgd2_4
[16:07:57] Fixed 2 duplicate /gene - fbiB_1 fbiB_2
[16:07:57] Fixed 2 duplicate /gene - bacC_1 bacC_2
[16:07:57] Fixed 3 duplicate /gene - tcrX_1 tcrX_2 tcrX_3
[16:07:57] Fixed 2 duplicate /gene - pyrE_1 pyrE_2
[16:07:57] Fixed 2 duplicate /gene - pbpB_1 pbpB_2
[16:07:57] Fixed 2 duplicate /gene - tesB_1 tesB_2
[16:07:57] Fixed 3 duplicate /gene - tcrY_1 tcrY_2 tcrY_3
[16:07:57] Fixed 2 duplicate /gene - ansP2_1 ansP2_2
[16:07:57] Fixed 2 duplicate /gene - papA2_1 papA2_2
[16:07:57] Fixed 2 duplicate /gene - pra_1 pra_2
[16:07:57] Fixed 2 duplicate /gene - eccB3_1 eccB3_2
[16:07:57] Fixed 2 duplicate /gene - rpsR1_1 rpsR1_2
[16:07:57] Fixed 2 duplicate /gene - htpX_1 htpX_2
[16:07:57] Fixed 3 duplicate /gene - fabG_1 fabG_2 fabG_3
[16:07:57] Fixed 2 duplicate /gene - dnaB_1 dnaB_2
[16:07:57] Fixed 2 duplicate /gene - clpC1_1 clpC1_2
[16:07:57] Fixed 2 duplicate /gene - higB2_1 higB2_2
[16:07:57] Fixed 3 duplicate /gene - dhmA2_1 dhmA2_2 dhmA2_3
[16:07:57] Fixed 2 duplicate /gene - dinB1_1 dinB1_2
[16:07:57] Fixed 2 duplicate /gene - arsR1_1 arsR1_2
[16:07:57] Fixed 2 duplicate /gene - csoR_1 csoR_2
[16:07:57] Fixed 2 duplicate /gene - PE5_1 PE5_2
[16:07:57] Fixed 2 duplicate /gene - vapB5_1 vapB5_2
[16:07:57] Fixed 3 duplicate /gene - inhA_1 inhA_2 inhA_3
[16:07:57] Fixed 2 duplicate /gene - trxC_1 trxC_2
[16:07:57] Fixed 2 duplicate /gene - galE_1 galE_2
[16:07:57] Fixed 3 duplicate /gene - atsA_1 atsA_2 atsA_3
[16:07:57] Fixed 2 duplicate /gene - gmd_1 gmd_2
[16:07:57] Fixed 2 duplicate /gene - lprE_1 lprE_2
[16:07:57] Fixed 2 duplicate /gene - nicC_1 nicC_2
[16:07:57] Fixed 2 duplicate /gene - fbpA_1 fbpA_2
[16:07:57] Fixed 2 duplicate /gene - hyfB_1 hyfB_2
[16:07:57] Fixed 2 duplicate /gene - secA_1 secA_2
[16:07:57] Fixed 2 duplicate /gene - lpdA_1 lpdA_2
[16:07:57] Fixed 2 duplicate /gene - pucR_1 pucR_2
[16:07:57] Fixed 3 duplicate /gene - narK_1 narK_2 narK_3
[16:07:57] Fixed 3 duplicate /gene - sugC_1 sugC_2 sugC_3
[16:07:57] Fixed 2 duplicate /gene - lnt_1 lnt_2
[16:07:57] Fixed 2 duplicate /gene - bmr3_1 bmr3_2
[16:07:57] Fixed 2 duplicate /gene - dmdC_1 dmdC_2
[16:07:57] Fixed 2 duplicate /gene - gcvT_1 gcvT_2
[16:07:57] Fixed 2 duplicate /gene - msrR_1 msrR_2
[16:07:57] Fixed 2 duplicate /gene - cya_1 cya_2
[16:07:57] Fixed 2 duplicate /gene - walR_1 walR_2
[16:07:57] Fixed 2 duplicate /gene - frdB_1 frdB_2
[16:07:57] Fixed 2 duplicate /gene - nfdA_1 nfdA_2
[16:07:57] Fixed 2 duplicate /gene - ahpD_1 ahpD_2
[16:07:57] Fixed 3 duplicate /gene - rsfA_1 rsfA_2 rsfA_3
[16:07:57] Fixed 2 duplicate /gene - ideR_1 ideR_2
[16:07:57] Fixed 2 duplicate /gene - espK_1 espK_2
[16:07:57] Fixed 3 duplicate /gene - dacB_1 dacB_2 dacB_3
[16:07:57] Fixed 3 duplicate /gene - lprJ_1 lprJ_2 lprJ_3
[16:07:57] Fixed 2 duplicate /gene - ctpI_1 ctpI_2
[16:07:57] Fixed 2 duplicate /gene - caeB_1 caeB_2
[16:07:57] Fixed 2 duplicate /gene - pgsA1_1 pgsA1_2
[16:07:57] Fixed 2 duplicate /gene - moaA1_1 moaA1_2
[16:07:57] Fixed 2 duplicate /gene - pknH_1 pknH_2
[16:07:57] Fixed 3 duplicate /gene - narX_1 narX_2 narX_3
[16:07:57] Fixed 4 duplicate /gene - espI_1 espI_2 espI_3 espI_4
[16:07:57] Fixed 3 duplicate /gene - mmpS4_1 mmpS4_2 mmpS4_3
[16:07:57] Fixed 8 duplicate /gene - mlaE_1 mlaE_2 mlaE_3 mlaE_4 mlaE_5 mlaE_6 mlaE_7 mlaE_8
[16:07:57] Fixed 2 duplicate /gene - rpmG2_1 rpmG2_2
[16:07:57] Fixed 2 duplicate /gene - paaG_1 paaG_2
[16:07:57] Fixed 2 duplicate /gene - bicA_1 bicA_2
[16:07:57] Fixed 2 duplicate /gene - ethR_1 ethR_2
[16:07:57] Fixed 3 duplicate /gene - ligD_1 ligD_2 ligD_3
[16:07:57] Fixed 2 duplicate /gene - ppsA_1 ppsA_2
[16:07:57] Fixed 2 duplicate /gene - ftsH_1 ftsH_2
[16:07:57] Fixed 2 duplicate /gene - menG_1 menG_2
[16:07:57] Fixed 4 duplicate /gene - plsC_1 plsC_2 plsC_3 plsC_4
[16:07:57] Fixed 2 duplicate /gene - ubiE_1 ubiE_2
[16:07:57] Fixed 2 duplicate /gene - moaE2_1 moaE2_2
[16:07:57] Fixed 2 duplicate /gene - resA_1 resA_2
[16:07:57] Fixed 3 duplicate /gene - sadH_1 sadH_2 sadH_3
[16:07:57] Fixed 2 duplicate /gene - qorA_1 qorA_2
[16:07:57] Fixed 3 duplicate /gene - trxA_1 trxA_2 trxA_3
[16:07:57] Fixed 2 duplicate /gene - pks1_1 pks1_2
[16:07:57] Fixed 2 duplicate /gene - dagK_1 dagK_2
[16:07:57] Fixed 2 duplicate /gene - pimB_1 pimB_2
[16:07:57] Fixed 2 duplicate /gene - aspC_1 aspC_2
[16:07:57] Fixed 2 duplicate /gene - virS_1 virS_2
[16:07:57] Fixed 2 duplicate /gene - gpmA_1 gpmA_2
[16:07:57] Fixed 2 duplicate /gene - adhB_1 adhB_2
[16:07:57] Fixed 2 duplicate /gene - ripA_1 ripA_2
[16:07:57] Fixed 4 duplicate /gene - cyaB_1 cyaB_2 cyaB_3 cyaB_4
[16:07:57] Fixed 2 duplicate /gene - eccD1_1 eccD1_2
[16:07:57] Fixed 2 duplicate /gene - srpR_1 srpR_2
[16:07:57] Fixed 2 duplicate /gene - tadA_1 tadA_2
[16:07:57] Fixed 2 duplicate /gene - uvrD1_1 uvrD1_2
[16:07:57] Fixed 3 duplicate /gene - pnbA_1 pnbA_2 pnbA_3
[16:07:57] Fixed 2 duplicate /gene - cobQ_1 cobQ_2
[16:07:57] Fixed 2 duplicate /gene - aofH_1 aofH_2
[16:07:57] Fixed 2 duplicate /gene - estB_1 estB_2
[16:07:57] Fixed 2 duplicate /gene - tuf_1 tuf_2
[16:07:57] Fixed 2 duplicate /gene - ampC_1 ampC_2
[16:07:57] Fixed 2 duplicate /gene - eccC5_1 eccC5_2
[16:07:57] Fixed 2 duplicate /gene - mmpL4_1 mmpL4_2
[16:07:57] Fixed 2 duplicate /gene - dxs_1 dxs_2
[16:07:57] Fixed 3 duplicate /gene - accD5_1 accD5_2 accD5_3
[16:07:57] Fixed 2 duplicate /gene - embR_1 embR_2
[16:07:57] Fixed 3 duplicate /gene - uctC_1 uctC_2 uctC_3
[16:07:57] Fixed 2 duplicate /gene - pknD_1 pknD_2
[16:07:57] Fixed 4 duplicate /gene - pcaF_1 pcaF_2 pcaF_3 pcaF_4
[16:07:57] Fixed 2 duplicate /gene - pip_1 pip_2
[16:07:57] Fixed 2 duplicate /gene - aidB_1 aidB_2
[16:07:57] Fixed 2 duplicate /gene - yhdG_1 yhdG_2
[16:07:57] Fixed 5 duplicate /gene - crt_1 crt_2 crt_3 crt_4 crt_5
[16:07:57] Fixed 2 duplicate /gene - ettA_1 ettA_2
[16:07:57] Fixed 2 duplicate /gene - ddn_1 ddn_2
[16:07:57] Fixed 2 duplicate /gene - mutB_1 mutB_2
[16:07:57] Fixed 2 duplicate /gene - noeI_1 noeI_2
[16:07:57] Fixed 2 duplicate /gene - sdhA_1 sdhA_2
[16:07:57] Fixed 5 duplicate /gene - rebM_1 rebM_2 rebM_3 rebM_4 rebM_5
[16:07:57] Fixed 2 duplicate /gene - vapC5_1 vapC5_2
[16:07:57] Fixed 2 duplicate /gene - ord_1 ord_2
[16:07:57] Fixed 2 duplicate /gene - serB1_1 serB1_2
[16:07:57] Fixed 2 duplicate /gene - rcdA_1 rcdA_2
[16:07:57] Fixed 3 duplicate /gene - lipF_1 lipF_2 lipF_3
[16:07:57] Fixed 2 duplicate /gene - recD_1 recD_2
[16:07:57] Fixed 2 duplicate /gene - vapC9_1 vapC9_2
[16:07:57] Fixed 2 duplicate /gene - mmpL8_1 mmpL8_2
[16:07:57] Fixed 3 duplicate /gene - hsaB_1 hsaB_2 hsaB_3
[16:07:57] Fixed 2 duplicate /gene - gppA_1 gppA_2
[16:07:57] Fixed 2 duplicate /gene - sbnA_1 sbnA_2
[16:07:57] Fixed 3 duplicate /gene - ethA_1 ethA_2 ethA_3
[16:07:57] Fixed 3 duplicate /gene - fgd1_1 fgd1_2 fgd1_3
[16:07:57] Fixed 2 duplicate /gene - mmsB_1 mmsB_2
[16:07:57] Fixed 2 duplicate /gene - betI_1 betI_2
[16:07:57] Fixed 2 duplicate /gene - fabG2_1 fabG2_2
[16:07:57] Fixed 4 duplicate /gene - lipY_1 lipY_2 lipY_3 lipY_4
[16:07:57] Fixed 2 duplicate /gene - ubiB_1 ubiB_2
[16:07:57] Fixed 2 duplicate /gene - tetR_1 tetR_2
[16:07:57] Fixed 2 duplicate /gene - trkA_1 trkA_2
[16:07:57] Fixed 3 duplicate /gene - rpmB_1 rpmB_2 rpmB_3
[16:07:57] Fixed 2 duplicate /gene - mca_1 mca_2
[16:07:57] Fixed 2 duplicate /gene - rbn_1 rbn_2
[16:07:57] Fixed 7 duplicate /gene - nlhH_1 nlhH_2 nlhH_3 nlhH_4 nlhH_5 nlhH_6 nlhH_7
[16:07:57] Fixed 3 duplicate /gene - drrA_1 drrA_2 drrA_3
[16:07:57] Fixed 2 duplicate /gene - acg_1 acg_2
[16:07:57] Fixed 2 duplicate /gene - xerC_1 xerC_2
[16:07:57] Fixed 2 duplicate /gene - epsE_1 epsE_2
[16:07:57] Fixed 2 duplicate /gene - ttgV_1 ttgV_2
[16:07:57] Fixed 3 duplicate /gene - echA8_1 echA8_2 echA8_3
[16:07:57] Fixed 2 duplicate /gene - cobB_1 cobB_2
[16:07:57] Fixed 3 duplicate /gene - ribBA_1 ribBA_2 ribBA_3
[16:07:57] Fixed 3 duplicate /gene - ephA_1 ephA_2 ephA_3
[16:07:57] Fixed 2 duplicate /gene - esxR_1 esxR_2
[16:07:57] Fixed 2 duplicate /gene - dprE1_1 dprE1_2
[16:07:57] Fixed 2 duplicate /gene - cobK_1 cobK_2
[16:07:57] Fixed 2 duplicate /gene - hepT_1 hepT_2
[16:07:57] Fixed 3 duplicate /gene - bpoC_1 bpoC_2 bpoC_3
[16:07:57] Fixed 2 duplicate /gene - vapC_1 vapC_2
[16:07:57] Fixed 2 duplicate /gene - accA1_1 accA1_2
[16:07:57] Fixed 3 duplicate /gene - soj_1 soj_2 soj_3
[16:07:57] Fixed 2 duplicate /gene - acrC_1 acrC_2
[16:07:57] Fixed 2 duplicate /gene - dhbF_1 dhbF_2
[16:07:57] Fixed 4 duplicate /gene - pspA_1 pspA_2 pspA_3 pspA_4
[16:07:57] Fixed 2 duplicate /gene - cysW_1 cysW_2
[16:07:57] Fixed 2 duplicate /gene - caiD_1 caiD_2
[16:07:57] Fixed 2 duplicate /gene - sap_1 sap_2
[16:07:57] Fixed 2 duplicate /gene - chp1_1 chp1_2
[16:07:57] Fixed 5 duplicate /gene - acr1_1 acr1_2 acr1_3 acr1_4 acr1_5
[16:07:57] Fixed 2 duplicate /gene - tlyC_1 tlyC_2
[16:07:57] Fixed 2 duplicate /gene - tam_1 tam_2
[16:07:57] Fixed 3 duplicate /gene - oatA_1 oatA_2 oatA_3
[16:07:57] Fixed 3 duplicate /gene - araQ_1 araQ_2 araQ_3
[16:07:57] Fixed 2 duplicate /gene - ugpA_1 ugpA_2
[16:07:57] Fixed 5 duplicate /gene - PE3_1 PE3_2 PE3_3 PE3_4 PE3_5
[16:07:57] Fixed 2 duplicate /gene - oxyR_1 oxyR_2
[16:07:57] Fixed 2 duplicate /gene - mshD_1 mshD_2
[16:07:57] Fixed 2 duplicate /gene - cmoB_1 cmoB_2
[16:07:57] Fixed 7 duplicate /gene - kstR2_1 kstR2_2 kstR2_3 kstR2_4 kstR2_5 kstR2_6 kstR2_7
[16:07:57] Fixed 2 duplicate /gene - fadD3_1 fadD3_2
[16:07:57] Fixed 2 duplicate /gene - greA_1 greA_2
[16:07:57] Fixed 2 duplicate /gene - ephD_1 ephD_2
[16:07:57] Fixed 2 duplicate /gene - pknE_1 pknE_2
[16:07:57] Fixed 5 duplicate /gene - lprN_1 lprN_2 lprN_3 lprN_4 lprN_5
[16:07:57] Fixed 7 duplicate /gene - mmgC_1 mmgC_2 mmgC_3 mmgC_4 mmgC_5 mmgC_6 mmgC_7
[16:07:57] Fixed 2 duplicate /gene - mmpS3_1 mmpS3_2
[16:07:57] Fixed 3 duplicate /gene - lppA_1 lppA_2 lppA_3
[16:07:57] Fixed 2 duplicate /gene - lrp_1 lrp_2
[16:07:57] Fixed 2 duplicate /gene - PPE4_1 PPE4_2
[16:07:57] Fixed 2 duplicate /gene - yedY_1 yedY_2
[16:07:57] Fixed 2 duplicate /gene - argO_1 argO_2
[16:07:57] Fixed 2 duplicate /gene - vapC3_1 vapC3_2
[16:07:57] Fixed 2 duplicate /gene - priA_1 priA_2
[16:07:57] Fixed 2 duplicate /gene - ubiG_1 ubiG_2
[16:07:57] Fixed 2 duplicate /gene - higA2_1 higA2_2
[16:07:57] Fixed 2 duplicate /gene - mmpL5_1 mmpL5_2
[16:07:57] Fixed 2 duplicate /gene - moaE1_1 moaE1_2
[16:07:57] Fixed 2 duplicate /gene - fdxA_1 fdxA_2
[16:07:57] Fixed 2 duplicate /gene - murF_1 murF_2
[16:07:57] Fixed 2 duplicate /gene - stp_1 stp_2
[16:07:57] Fixed 2 duplicate /gene - hspX_1 hspX_2
[16:07:57] Fixed 2 duplicate /gene - fadA_1 fadA_2
[16:07:57] Fixed 2 duplicate /gene - icaR_1 icaR_2
[16:07:57] Fixed 2 duplicate /gene - pimF_1 pimF_2
[16:07:57] Fixed 2 duplicate /gene - lysX_1 lysX_2
[16:07:57] Fixed 2 duplicate /gene - mmpL3_1 mmpL3_2
[16:07:57] Fixed 2 duplicate /gene - cocE_1 cocE_2
[16:07:57] Fixed 4 duplicate /gene - acdA_1 acdA_2 acdA_3 acdA_4
[16:07:57] Fixed 2 duplicate /gene - moaC1_1 moaC1_2
[16:07:57] Fixed 2 duplicate /gene - espJ_1 espJ_2
[16:07:57] Fixed 2 duplicate /gene - cut3_1 cut3_2
[16:07:57] Fixed 2 duplicate /gene - fadH_1 fadH_2
[16:07:57] Fixed 3 duplicate /gene - gloC_1 gloC_2 gloC_3
[16:07:57] Fixed 2 duplicate /gene - dnaX_1 dnaX_2
[16:07:57] Fixed 2 duplicate /gene - nei1_1 nei1_2
[16:07:57] Fixed 2 duplicate /gene - amiD_1 amiD_2
[16:07:57] Fixed 2 duplicate /gene - hypB_1 hypB_2
[16:07:57] Fixed 2 duplicate /gene - menA_1 menA_2
[16:07:57] Fixed 3 duplicate /gene - moeZ_1 moeZ_2 moeZ_3
[16:07:57] Fixed 4 duplicate /gene - lcfB_1 lcfB_2 lcfB_3 lcfB_4
[16:07:57] Fixed 4 duplicate /gene - cpo_1 cpo_2 cpo_3 cpo_4
[16:07:57] Fixed 2 duplicate /gene - mtnN_1 mtnN_2
[16:07:57] Fixed 217 colliding /gene names.
[16:07:57] Adding /locus_tag identifiers
[16:07:57] Assigned 4301 locus_tags to CDS and RNA features.
[16:07:57] Writing outputs to ./G04870_prokka/
[16:08:05] Generating annotation statistics file
[16:08:05] Generating Genbank and Sequin files
[16:08:05] Running: tbl2asn -V b -a r10k -l paired-ends -M n -N 1 -y 'Annotated using prokka 1.12 from https://github.com/tseemann/prokka' -Z \.\/G04870_prokka\/G04870\.err -i \.\/G04870_prokka\/G04870\.fsa 2> /dev/null
[16:08:16] Deleting unwanted file: ./G04870_prokka/errorsummary.val
[16:08:16] Deleting unwanted file: ./G04870_prokka/G04870.dr
[16:08:16] Deleting unwanted file: ./G04870_prokka/G04870.fixedproducts
[16:08:16] Deleting unwanted file: ./G04870_prokka/G04870.ecn
[16:08:16] Deleting unwanted file: ./G04870_prokka/G04870.val
[16:08:16] Repairing broken .GBK output that tbl2asn produces...
[16:08:16] Running: sed 's/COORDINATES: profile/COORDINATES:profile/' < \.\/G04870_prokka\/G04870\.gbf > \.\/G04870_prokka\/G04870\.gbk
[16:08:16] Deleting unwanted file: ./G04870_prokka/G04870.gbf
[16:08:16] Output files:
[16:08:16] ./G04870_prokka/G04870.err
[16:08:16] ./G04870_prokka/G04870.faa
[16:08:16] ./G04870_prokka/G04870.ffn
[16:08:16] ./G04870_prokka/G04870.fna
[16:08:16] ./G04870_prokka/G04870.fsa
[16:08:16] ./G04870_prokka/G04870.gbk
[16:08:16] ./G04870_prokka/G04870.gff
[16:08:16] ./G04870_prokka/G04870.log
[16:08:16] ./G04870_prokka/G04870.sqn
[16:08:16] ./G04870_prokka/G04870.tbl
[16:08:16] ./G04870_prokka/G04870.tsv
[16:08:16] ./G04870_prokka/G04870.txt
[16:08:16] Annotation finished successfully.
[16:08:16] Walltime used: 4.45 minutes
[16:08:16] If you use this result please cite the Prokka paper:
[16:08:16] Seemann T (2014) Prokka: rapid prokaryotic genome annotation. Bioinformatics. 30(14):2068-9.
[16:08:16] Type 'prokka --citation' for more details.
[16:08:16] Share and enjoy!


>>>>> gzip_compression <<<<<


gzip -c G04870_1.fastq > G04870_1.fastq.gz
^[[B




>>>>> gzip_compression <<<<<


gzip -c G04870_2.fastq > G04870_2.fastq.gz





>>>>> snippy_command <<<<<


snippy --cpus 1 --outdir G04870 --ref ./NC000962_3.gbk --R1 ./G04870_1.fastq.gz --R2 ./G04870_2.fastq.gz
[16:13:37] This is snippy 3.2-dev
[16:13:37] Written by Torsten Seemann <torsten.seemann@gmail.com>
[16:13:37] Obtained from https://github.com/tseemann/snippy
[16:13:37] Detected operating system: linux
[16:13:37] Enabling bundled linux tools.
[16:13:37] Found bwa - /opt/snippy/binaries/linux/bwa
[16:13:37] Found samtools - /opt/snippy/binaries/linux/samtools
[16:13:37] Found tabix - /opt/snippy/binaries/linux/tabix
[16:13:37] Found bgzip - /opt/snippy/binaries/linux/bgzip
[16:13:37] Found snpEff - /opt/snippy/binaries/noarch/snpEff
[16:13:37] Found java - /usr/bin/java
[16:13:37] Found gzip - /usr/bin/gzip
[16:13:37] Found parallel - /opt/snippy/binaries/noarch/parallel
[16:13:37] Found freebayes - /opt/snippy/binaries/linux/freebayes
[16:13:37] Found freebayes-parallel - /opt/snippy/binaries/noarch/freebayes-parallel
[16:13:37] Found fasta_generate_regions.py - /opt/snippy/binaries/noarch/fasta_generate_regions.py
[16:13:37] Found vcfstreamsort - /opt/snippy/binaries/linux/vcfstreamsort
[16:13:37] Found vcfuniq - /opt/snippy/binaries/linux/vcfuniq
[16:13:37] Found vcffirstheader - /opt/snippy/binaries/noarch/vcffirstheader
[16:13:37] Found vcf-consensus - /opt/snippy/binaries/noarch/vcf-consensus
[16:13:37] Found snippy-vcf_to_tab - /opt/snippy/bin/snippy-vcf_to_tab
[16:13:37] Found snippy-vcf_report - /opt/snippy/bin/snippy-vcf_report
[16:13:37] Found snippy-vcf_filter - /opt/snippy/bin/snippy-vcf_filter
[16:13:37] Checking version: samtools --version is >= 1.3 - ok, have 1.3
[16:13:37] Using reference: /media/sf_Genomes/a3_double_genome_single_script/G04870_analysis/NC000962_3.gbk
[16:13:37] Treating reference as 'genbank' format.
[16:13:37] Will use 1 CPU cores.
[16:13:37] Using read file: /media/sf_Genomes/a3_double_genome_single_script/G04870_analysis/G04870_1.fastq.gz
[16:13:37] Using read file: /media/sf_Genomes/a3_double_genome_single_script/G04870_analysis/G04870_2.fastq.gz
[16:13:37] Creating folder: G04870
[16:13:37] Changing working directory: G04870
[16:13:37] Creating reference folder: reference
[16:13:37] Extracting FASTA and GFF from reference.
[16:13:41] Wrote 1 sequences to ref.fa
[16:13:41] Wrote 4416 features to ref.gff
[16:13:41] Creating reference/snpeff.config
[16:13:41] Freebayes will process 4 chunks of 1121279 bp, 1 chunks at a time.
[16:13:41] Using BAM RG (Read Group) ID: snps
[16:13:41] Running: samtools faidx reference/ref.fa 2>> snps.log
[16:13:41] Running: bwa index reference/ref.fa 2>> snps.log
[16:13:43] Running: mkdir reference/genomes && cp -f reference/ref.fa reference/genomes/ref.fa 2>> snps.log
[16:13:43] Running: mkdir reference/ref && bgzip -c reference/ref.gff > reference/ref/genes.gff.gz 2>> snps.log
[16:13:44] Running: snpEff build -c reference/snpeff.config -dataDir . -gff3 ref 2>> snps.log
[16:13:49] Running: (bwa mem  -v 2 -M -R '@RG\tID:snps\tSM:snps' -t 1 reference/ref.fa /media/sf_Genomes/a3_double_genome_single_script/G04870_analysis/G04870_1.fastq.gz /media/sf_Genomes/a3_double_genome_single_script/G04870_analysis/G04870_2.fastq.gz | samtools sort --reference reference/ref.fa > snps.bam) 2>> snps.log
[16:24:50] Running: samtools index snps.bam 2>> snps.log
[16:25:02] Running: samtools depth -q 20 snps.bam | bgzip > snps.depth.gz 2>> snps.log
[16:25:33] Running: tabix -s 1 -b 2 -e 2 snps.depth.gz 2>> snps.log
[16:25:34] Running: fasta_generate_regions.py reference/ref.fa.fai 1121279 > reference/ref.txt 2>> snps.log
[16:25:34] Running: freebayes-parallel reference/ref.txt 1 -p 1 -q 20 -m 60 --min-coverage 10 -V -f reference/ref.fa snps.bam > snps.raw.vcf 2>> snps.log
[16:33:36] Running: /opt/snippy/bin/snippy-vcf_filter --minqual 10 --mincov 10 --minfrac 0.9  snps.raw.vcf > snps.filt.vcf 2>> snps.log
[16:33:36] Running: snpEff ann -no-downstream -no-upstream -no-intergenic -no-utr -c reference/snpeff.config -dataDir . -noStats ref snps.filt.vcf > snps.vcf 2>> snps.log
[16:33:41] Running: bgzip -c snps.vcf > snps.vcf.gz 2>> snps.log
[16:33:41] Running: tabix -p vcf snps.vcf.gz 2>> snps.log
[16:33:41] Running: /opt/snippy/bin/snippy-vcf_to_tab --gff reference/ref.gff --ref reference/ref.fa --vcf snps.vcf > snps.tab 2>> snps.log
[16:33:45] Running: vcf-consensus snps.vcf.gz < reference/ref.fa > snps.consensus.fa 2>> snps.log
[16:33:46] Running: /opt/snippy/bin/snippy-vcf_filter --subs snps.filt.vcf > snps.filt.subs.vcf 2>> snps.log
[16:33:46] Running: bgzip -c snps.filt.subs.vcf > snps.filt.subs.vcf.gz 2>> snps.log
[16:33:46] Running: tabix -p vcf snps.filt.subs.vcf.gz 2>> snps.log
[16:33:46] Running: vcf-consensus snps.filt.subs.vcf.gz < reference/ref.fa > snps.consensus.subs.fa 2>> snps.log
[16:33:47] Generating aligned/masked FASTA relative to reference: snps.aligned.fa
[16:33:52] Creating extra output files: BED GFF CSV TXT HTML
[16:33:52] Identified 2249 variants.
[16:33:52] Result folder: G04870
[16:33:52] Result files:
[16:33:52] * G04870/snps.aligned.fa
[16:33:52] * G04870/snps.bam
[16:33:52] * G04870/snps.bam.bai
[16:33:52] * G04870/snps.bed
[16:33:52] * G04870/snps.consensus.fa
[16:33:52] * G04870/snps.consensus.subs.fa
[16:33:52] * G04870/snps.csv
[16:33:52] * G04870/snps.depth.gz
[16:33:52] * G04870/snps.depth.gz.tbi
[16:33:52] * G04870/snps.filt.subs.vcf
[16:33:52] * G04870/snps.filt.subs.vcf.gz
[16:33:52] * G04870/snps.filt.subs.vcf.gz.tbi
[16:33:52] * G04870/snps.filt.vcf
[16:33:52] * G04870/snps.gff
[16:33:52] * G04870/snps.html
[16:33:52] * G04870/snps.log
[16:33:52] * G04870/snps.raw.vcf
[16:33:52] * G04870/snps.tab
[16:33:52] * G04870/snps.txt
[16:33:52] * G04870/snps.vcf
[16:33:52] * G04870/snps.vcf.gz
[16:33:52] * G04870/snps.vcf.gz.tbi
[16:33:52] Walltime used: 20 minutes, 15 seconds
[16:33:52] Found a bug? Post it at https://github.com/tseemann/snippy/issues
[16:33:52] Done.


>>>>> snippy_core <<<<<


snippy-core  G04870 
[16:33:52] Loading Snippy folders
[16:33:52] Using ID 'G04870' for G04870
[16:33:52] G04870: found 2114 variants totalling 2261 bp in G04870/snps.tab
[16:33:52] Loaded 1 SNP tables.
[16:33:52] Including 'Reference' in results.
[16:33:52] Will write alignment statistics to core.txt
[16:33:52] Loading pre-masked/aligned sequences...
[16:33:52] 1/1  G04870 coverage 4379535/4411532 = 99.27%
[16:33:52] Patching variant sites into whole genome alignment...
[16:33:52] Constructing alignment object for core.full.aln
[16:33:53] Writing 'fasta' alignment to core.full.aln
[16:33:53] Writing core SNP table
[16:33:53] Found 2178 core SNPs from 2261 variant sites.
[16:33:53] Saved SNP table: core.tab
[16:33:53] Constructing alignment object for core.aln
[16:33:53] Writing 'fasta' alignment to core.aln
[16:33:53] Done.


>>>>> SNPtable <<<<<


SNPtable_filter_Mtb.R core.tab
SNPtable_filter_Mtb v1.0

Author: João Perdigão

Usage: SNPtable_filter_Mtb.R [snippy-core SNP tab file]

Loading required package: ape
Loading required package: seqinr

Attaching package: ‘seqinr’

The following objects are masked from ‘package:ape’:

    as.alignment, consensus

Reading M. tuberculosis library files...

Reading M. tuberculosis library files...OK!

PE/PPE Positions removed...

Positions with mapping quality below k-mer 49/50 removed...

Converting to multifasta format...

Conversion to multifasta format... OK!

Output FASTA file: coreSNP_alignment_filtered.fas


>>>>> HammingFasta <<<<<


HammingFasta.R coreSNP_alignment_filtered.fas
HammingFasta v1.0

Author: João Perdigão

Usage: HammingFasta.R [FASTA alignment file]


Loading required package: ape
Loading required package: seqinr

Attaching package: ‘seqinr’

The following objects are masked from ‘package:ape’:

    as.alignment, consensus

       H37Rv
G04870  2090

Output Matrix File: dists_hamming.csv


>>>>> move_out_of_genome_folder <<<<<




centos-sf_Genomes@ 
