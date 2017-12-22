// Move all the genomes as per the division of good and bad genomes




var bad_genomes = Array(
    "G04870",
    "G04874 ",
    "G04878 ",
    "G04879",
    "G04880  ",
    "G04882 ",
    "G04885 ",
    "G04886",
    "G04889",
    "G04890",
    "G04893",
    "G04894",
    "G04895",
    "G04896",
    "G04897",
    "G04958"
)


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

  var target_folder = pwd + "/" + kind

  var cmd_string = "mv " + genomeName + " " + target_folder

  println(cmd_string + "\n\n")

//  %%("bash", "-c", cmd_string)
}





