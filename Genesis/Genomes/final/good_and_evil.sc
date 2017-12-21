
var all_files = ls! pwd


def file_name_has_genome_name_?(file_name:String, genome_name:String) : Boolean = {


  var genome_reg_exp = "_" + genome_name + "_"

  return file_name.contains(genome_reg_exp)

}





def all_files_for_a_genome(genome_name:String) :Seq[String] = {

  var genome_files = all_files.filter( (f) => file_name_has_genome_name_?(f.toString, genome_name) ).map((f) => f.toString)
    //println(genome_files)

  return genome_files
}




// Calling the << combine_all_r_code_files_for_genome >> functions per genome for both << R >> files
 // The << println >> is used for a well informed user experience while running the script
 def move_a_genome(genomeName:String, kind:String ) = {

  var cmd_string = "mv " + genomeName + " ./" + kind + "/"

  println(cmd_string + "\n\n")

 // %%("bash", "-c", cmd_string)
 }




var all_fastq_files = all_files.filter( (f) => is_fastq_?(f.toString) ).map( (f) => f.toString)



// Usage
// find_unique_genomes_fastq(all_fastq_files)

def find_unique_genomes_fastq(all_fastq_files: Seq[String]): ArrayBuffer[String] = {

  var  all_genome_list = ArrayBuffer[String]()

  for (file_name <- all_fastq_files) {

    var genome_name = file_name.toString.split("/").last.split("_")(6)

    all_genome_list += genome_name


  }

  return all_genome_list.distinct

}


