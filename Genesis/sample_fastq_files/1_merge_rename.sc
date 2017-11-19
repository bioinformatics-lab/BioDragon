
import ammonite.ops._
import ammonite.ops.ImplicitWd._



var all_fastq_files = ls! pwd |? grep! "fastq"



# Usage
#findUniqueGenomes(allFastqFiles)

def findUniqueGenomes(allFastqFiles)
  allGenomeList = []

  for fileName in allFastqFiles
    genomeName = fileName.split("_")[6]

    allGenomeList.push(genomeName)
  end

  uniqueGenomeList = (allGenomeList.uniq).compact
  return uniqueGenomeList
end

# Usage
# allFilesForAGenome("G04868")
def allFilesForAGenome (genome)
  genomeRegExp = "*_" + genome + "_*"

  return Dir[genomeRegExp]
end

# Usage
# combineAllRCodeFilesForGenome("G04868","R1")
def combineAllRCodeFilesForGenome(genome, rCode)
  outputFileName = (genome).to_s + "_" + rCode + ".fastq"

  filesForAGenome = allFilesForAGenome(genome)

  rCodeFilesForAGenome = []

  for f in filesForAGenome
    rPart = f.split("_")[-2]

    if rPart == rCode
      rCodeFilesForAGenome.push(f)
    end
  end

  #return rCodeFilesForAGenome

  # construct the string to be executed by the shell
  cmd = "cat "
  # combine the names of the files into a single string
  for file in rCodeFilesForAGenome
    cmd += file + " "
  end

  cmd += " > #{outputFileName}"
  puts cmd
  system(cmd)
end

# Here we call the << findUniqueGenomes >> function to store the unique genomes in another array.
uniqueGenomeList = findUniqueGenomes(allFastqFiles)


# Show time baby!
# Calling the << combineAllRCodeFilesForGenome >> functions per genome for both << R >> files
# The << puts >> is used for a well informed user experience while running the script
for genome in uniqueGenomeList
  puts "\n\n ~~~~~~~~~~~~~~~~~~~~~ "
  puts "\nWorking on the #{genome} files\n\n"
  puts "\n>>>>       R1      <<<<\n\n"
  combineAllRCodeFilesForGenome(genome,"R1")
  puts "\n\n"
  puts "\n>>>>       R2      <<<<\n\n"
  combineAllRCodeFilesForGenome(genome,"R2")
end

puts "\n\n\n@@@@@@@@@@@@@@@@@@@@@@@@"

puts "\n\nAll Done!"
