import ammonite.ops._

import ammonite.ops.ImplicitWd._

import scala.collection.mutable.ArrayBuffer

def is_fastq_?(file_name:String) : Boolean = {

  //  "ab c d e f".matches(".*f$")

  return file_name.matches(".*fastq$")

}


def file_name_has_genome_name_?(file_name:String, genome_name:String) : Boolean = {


  var genome_reg_exp = "_" + genome_name + "_"

  return file_name.contains(genome_reg_exp)

}

var all_files = ls! pwd


var all_fastq_files = all_files.filter( (f) => is_fastq_?(f.toString) ).map( (f) => f.toString)

