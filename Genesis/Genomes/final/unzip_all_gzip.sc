

import scala.collection.mutable.ArrayBuffer

def is_fastqgz_?(file_name:String) : Boolean = {

  //  "ab c d e f".matches(".*f$")

  return file_name.matches(".*fastq.gz$")

}



var all_files = ls! pwd


var all_fastqgz_files = all_files.filter( (f) => is_fastqgz_?(f.toString) ).map( (f) => f.toString)




//TODO: Unzip all the fastqgz files in the folder

// generate_fastq_names_from_fastqgz( "PT000033_1.fastq.gz")

def generate_fastq_names_from_fastqgz(fastqgz_name:String) : String = {
  var name_array = fastqgz_name.split("\\.")
  return { name_array(0) + ".fastq"}
}





// generate_fastq_names_from_fastqgz(all_fastq_files(0).toString)
def gzip_decompression(genome_name:String) = {

  var fastqgz_name = genome_name 

  var fastq_name = generate_fastq_names_from_fastqgz(fastqgz_name)

  var cmd_string =  "gzip -dc " + fastqgz_name + " > " + fastq_name

  %%("bash", "-c", cmd_string)
  //println(cmd_string)

  println("\n\n")
}







for(f <- all_fastqgz_files){

//println(f)
gzip_decompression(f)

}
