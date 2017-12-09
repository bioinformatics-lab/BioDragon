//import ammonite.ops._

//import ammonite.ops.ImplicitWd._

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



// Usage
// find_unique_genomes_fastq(all_fastq_files)

def find_unique_genomes_fastq(all_fastq_files: Seq[String]): ArrayBuffer[String] = {

  var  all_genome_list = ArrayBuffer[String]()

  for (file_name <- all_fastq_files) {

    var genome_name = file_name.toString.split("/").last.split("_")(6)

    all_genome_list += genome_name


    return all_genome_list

  }

  return all_genome_list.distinct

}



// Here we call the << find_unique_genomes_fastq >> function to store the unique genomes in another array.
// TODO: this is sensing only a single genome!
var unique_genome_list = find_unique_genomes_fastq(all_fastq_files).toList
//println(unique_genome_list)




// Usage
// all_files_for_a_genome("G04868")

def all_files_for_a_genome(genome_name:String) :Seq[String] = {

  var genome_files = all_files.filter( (f) => file_name_has_genome_name_?(f.toString, genome_name) ).map((f) => f.toString)
    //println(genome_files)

  return genome_files
}

def r_code(genome_name:String) : String = {

  return genome_name.split("/").last.split("_")(13)

}


// Usage
// r_code_files_for_a_genome("G04868","R1")
def r_code_files_for_a_genome(genome_name:String, r_code:String) : Seq[String] = {

  //  ".*G04868.*R1.*"
  var regex = ".*" + genome_name + ".*" + r_code + ".*"

  return all_fastq_files.filter((f) => f.matches(regex)).map((f) => f.toString)

}




// Usage
// combine_all_r_code_files_for_genome("G04868","R1")
def combine_all_r_code_files_for_genome(genome_name:String, r_code:String) = {

  var genome_dir_name = genome_name + "_analysis"

  mkdir! pwd/genome_dir_name

  var output_file_name = pwd.toString +  "/" + genome_dir_name +"/" + genome_name + "_" + r_code.toList(1) + ".fastq"

  var files_for_a_genome = all_files_for_a_genome(genome_name)



//  mkdir_genome_dir(genome_name)

  // println(files_for_a_genome)

  // println(r_code_files_for_a_genome)

  // construct the string to be executed by the shell
  var cmd_string = "cat "

  var list_of_files_to_be_concatenated = r_code_files_for_a_genome(genome_name, r_code)

  // combine the names of the files into a single string
  for (file <- list_of_files_to_be_concatenated ) {
    cmd_string += file + " "
  }

  cmd_string += " > " + output_file_name
  println(cmd_string)

   %("bash" , "-c", cmd_string)

}


// combine_all_r_code_files_for_genome("G04868","R1")



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


def move_into_genome_folder(genome_name: String) = {

  var genome_dir_name = genome_name + "_analysis"
  cd! pwd/genome_dir_name
}



def move_out_of_genome_folder() = {

  cd! pwd/up
}
