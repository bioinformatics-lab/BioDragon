import ammonite.ops._
import ammonite.ops.ImplicitWd._

// exists! home/'BioDragon

val wd = home/'BioDragon

var all_files = ls! wd/'course_files

all_files.foreach{println}


// val reference_genome = NC000962_3.fasta

ls! pwd/up


// "PT000033_1.fastq.gz" =>  "PT000033_1.fastq"

def generate_fastq_names_from_fastqgz(fastqgz_name:String) : String =
{
  var name_array = fastqgz_name.split("\\.")
  return { name_array(0) + ".fastq"}
}


def gzip_decompression(fastqgz_name:String) = {

  var fastq_name = generate_fastq_names_from_fastqgz(fastqgz_name)

  println("gzip -dc " + fastqgz_name + " > " + fastq_name )

}


