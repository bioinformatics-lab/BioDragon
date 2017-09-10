# How to use this powershell script:

# 1. Save this file in the << EAI Genome_Emilyn >> folder - along with the basic genome files to be merged.
# ( NOTE: Make sure of this with << Get-Location >> )

# 2. Move to the directory using << terminal >>

# 3. Next, type << biodragon.rb >>

# 4. You should see the desired files merged and saved properly



# First we generate a list of all files whose names end with << fastq >>
#$allFastqFiles = Get-ChildItem -Name -Filter "*fastq*"


allFastqFiles = Dir["*.fastq"]






# This function finds the names of the unique Genomes within the folder
# function findUniqueGenomes {

#                 # initialize an empty array
#                 $allGenomeNames = @()

#                 foreach ($fileName in $allFastqFiles) {
#                                 $allGenomeNames += $fileName.Split("_")[6]
#                 }
#                 return $allGenomeNames | Select-Object -Unique

# }





def findUniqueGenomes

                allGenomeNames = []

                for fileName in allFastqFiles

                   allGenomeNames << fileName.split("_")[6]

                end

                return allGenomeNames
end





# Generates the associated << FASTQ >> files for a particular genome
# function allFilesForAGenome {

#                 Param(
#                                 [parameter(Mandatory = $true)] [String] $genome


#                 )

#                 $genomeRegExp = "*_" + $genome + "_*"
#                 Get-ChildItem -Name  -Filter $genomeRegExp

# }



def allFilesForAGenome (genome )


  genomeRegExp = "*_" + genome + "_*"

return Dir[genomeRegExp]


end





# A function that returns the list of << R1 >> files associated with a genome
# function combineAllRCodeFilesForGenome {
#                 Param(
#                                 [parameter(Mandatory = $true, Position = 0)] [String] $genome,

#                                 [parameter(Mandatory = $true, Position = 1)] [String] $RCode

#                 )

#                 $outputFileName = ($genome).ToString() + "_" + $RCode + ".fastq"
#                 $filesForAGenome = allFilesForAGenome($genome)
#                 $RCodeFilesForAGenome = $filesForAGenome -like "*_" + $RCode + "_*"


#                 foreach ($anRCodeFile in $RCodeFilesForAGenome) {
#                                 Get-Content $anRCodeFile | Out-File -Append -NoNewline -Encoding ASCII $outputFileName

#                 }
# }


def combineAllRCodeFilesForGenome(genome, RCode)

outputFileName = (genome).to_s + "_" + RCode + ".fastq"

filesForAGenome = allFilesForAGenome(genome)

#RCodeFilesForAGenome = filesForAGenome -like "*_" + RCode + "_*"



end




# Here we call the << findUniqueFenomes >> function to store the unique genomes in another array.
uniqueGenomeNames = findUniqueGenomes()


# Show time, baby!
# foreach ($genome in $uniqueGenomeNames) {
#                 Write-Host "Working on the $genome files"
#                 combineAllRCodeFilesForGenome $genome "R1"
#                 combineAllRCodeFilesForGenome $genome "R2"
# }


for genome in uniqueGenomeNames

puts "Working on the #{genome} files"
combineAllRCodeFilesForGenome(genome,"R1")
combineAllRCodeFilesForGenome(genome,"R2")


end


#Write-Host "All Done"

puts "All Done!"
