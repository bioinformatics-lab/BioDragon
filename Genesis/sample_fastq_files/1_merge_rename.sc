
import ammonite.ops._
import ammonite.ops.ImplicitWd._


// var all_fastq_files = ls! pwd |? grep! "fastq"

// var all_fastq_files = ls! pwd |? grep! "fastq$".r

// var all_fastq_files = ls! pwd || grep! "fastq".r

// var all_fastq_files = ls! pwd || grep! "\\.fastq".r

// var all_fastq_files = ls! pwd |? grep! "\\.fastq".r



# Usage
# find_unique_genomes(all_fastq_files)

def find_unique_genomes(all_fastq_files:List[String])
  all_genome_list = []

  for file_name in all_fastq_files
    genome_name = file_name.split("_")[6]

    all_genome_list.push(genome_name)
  end

  unique_genome_list = (all_genome_list.uniq).compact
  return unique_genome_list
end

# Usage
# all_files_for_a_genome("G04868")
def all_files_for_a_genome (genome)
  genome_reg_exp = "*_" + genome + "_*"

  return Dir[genome_reg_exp]
end

# Usage
# combine_all_r_code_files_for_genome("G04868","R1")
def combine_all_r_code_files_for_genome(genome, rCode)
  output_file_name = (genome).to_s + "_" + rCode + ".fastq"

  files_for_a_genome = all_files_for_a_genome(genome)

  r_code_files_for_a_genome = []

  for f in files_for_a_genome
    rPart = f.split("_")[-2]

    if rPart == rCode
      r_code_files_for_a_genome.push(f)
    end
  end

  #return r_code_files_for_a_genome

  # construct the string to be executed by the shell
  cmd = "cat "
  # combine the names of the files into a single string
  for file in r_code_files_for_a_genome
    cmd += file + " "
  end

  cmd += " > #{output_file_name}"
  puts cmd
  system(cmd)
end

# Here we call the << find_unique_genomes >> function to store the unique genomes in another array.
unique_genome_list = find_unique_genomes(all_fastq_files)


# Show time baby!
# Calling the << combine_all_r_code_files_for_genome >> functions per genome for both << R >> files
# The << puts >> is used for a well informed user experience while running the script
for genome in unique_genome_list
  puts "\n\n ~~~~~~~~~~~~~~~~~~~~~ "
  puts "\nWorking on the #{genome} files\n\n"
  puts "\n>>>>       R1      <<<<\n\n"
  combine_all_r_code_files_for_genome(genome,"R1")
  puts "\n\n"
  puts "\n>>>>       R2      <<<<\n\n"
  combine_all_r_code_files_for_genome(genome,"R2")
end

puts "\n\n\n@@@@@@@@@@@@@@@@@@@@@@@@"

puts "\n\nAll Done!"
