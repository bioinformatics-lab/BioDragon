import ammonite.ops._
import ammonite.ops.ImplicitWd._

// exists! home/'BioDragon

val wd = home/'BioDragon

var all_files = ls! wd/'course_files

all_files.foreach{println}


// val reference_genome = NC000962_3.fasta

ls! pwd/up


// "PT000033_1.fastq.gz".split("\\.")

def generate_fasta_names_from_fastqgz(fastqgz_name:String) =
{
   fastqgz_name.split("\\.")
}

 def add9(x:Int) { println(x + 9 )}
