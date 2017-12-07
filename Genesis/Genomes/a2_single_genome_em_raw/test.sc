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

var all_fastq_files = all_files.filter( (f) => is_fastq_?(f.toString) )



// Usage
// find_unique_genomes(all_fastq_files)

def find_unique_genomes(all_fastq_files: Seq[Path]): ArrayBuffer[String] = {

var  all_genome_list = ArrayBuffer[String]()

for (file_name <- all_fastq_files) {

var genome_name = file_name.toString.split("/").last.split("_")(6)

  all_genome_list += genome_name


  return all_genome_list

}

return all_genome_list.distinct

}

// Usage
// all_files_for_a_genome("G04868")

def all_files_for_a_genome(genome_name:String) :Seq[Path] = {

  var genome_files = all_files.filter( (f) => file_name_has_genome_name_?(f.toString, genome_name) )
//println(genome_files)

  return genome_files
}



def r_code(genome_name:String) : String = {

return genome_name.toString.split("_")(18)

}



// Usage
// combine_all_r_code_files_for_genome("G04868","R1")
def combine_all_r_code_files_for_genome(genome_name:String, r_code:String) = {

//var genome_name = "G04868"
//var r_code = "R1"

var output_file_name = pwd.toString + "/" + genome_name + "_" + r_code + ".fastq"

var files_for_a_genome = all_files_for_a_genome(genome_name)

var r_code_files_for_a_genome = ArrayBuffer[String]()


  for (g <- files_for_a_genome) {

    println(r_code(g))
    var r_part = r_code(g)


  if (r_part == r_code) {
    r_code_files_for_a_genome += g.toString } }



  // println(r_code_files_for_a_genome)
  // return r_code_files_for_a_genome

  // construct the string to be executed by the shell
 var cmd_string = "cat "
  // combine the names of the files into a single string
  for (file <- r_code_files_for_a_genome) {
    cmd_string += file + " "
  }

  cmd_string += " > " + output_file_name
  println(cmd_string)

//  %("bash" , "-c", cmd_string)

}

// Here we call the << find_unique_genomes >> function to store the unique genomes in another array.
var unique_genome_list = find_unique_genomes(all_fastq_files).toList

println(unique_genome_list)


/*
// Show time baby!
// Calling the << combine_all_r_code_files_for_genome >> functions per genome for both << R >> files
// The << println >> is used for a well informed user experience while running the script
def merge_and_rename( ) = {
for(genome <- unique_genome_list){

  println("\n\n ~~~~~~~~~~~~~~~~~~~~~ ")
  println("\nworking on the " + genome + " files\n\n")
  println("\n>>>>       R1      <<<<\n\n")
  combine_all_r_code_files_for_genome(genome,"R1")
  println("\n\n")
  println("\n>>>>       R2      <<<<\n\n")
  combine_all_r_code_files_for_genome(genome,"R2")
}


println("\n\n\n@@@@@@@@@@@@@@@@@@@@@@@@")

println("\n\nAll Done!")

}

merge_and_rename()
 */ 
