# How to use this powershell script:

# 1. Save this file in the << EAI Genome_Emilyn >> folder - along with the basic genome files to be merged.
# ( NOTE: Make sure of this with << Get-Location >> )

# 2. Move to the directory using << terminal >>

# 3. Next, type << biodragon.rb >>

# 4. You should see the desired files merged and saved properly

# First we generate a list of all files whose names end with << fastq >>

allFastqFiles = Dir["*.fastq"]

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

  cmd = "cat "
# combine the names of the files into a fingle string
 for file in rCodeFilesForAGenome 

  cmd += file + " "

 end


cmd += " > #{outputFileName}"
puts cmd
end

# Here we call the << findUniqueFenomes >> function to store the unique genomes in another array.
uniqueGenomeList = findUniqueGenomes(allFastqFiles)

for genome in uniqueGenomeList
  puts "Working on the #{genome} files"
  combineAllRCodeFilesForGenome(genome,"R1")
  combineAllRCodeFilesForGenome(genome,"R2")
end

puts "All Done!"
