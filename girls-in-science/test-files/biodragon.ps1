<#

I'm assuming that you'd be using << Windows >> here

How to use this powershell script:

1. Save this file in the << EAI Genome_Emilyn >> folder - along with the basic genome files to be merged.

2. Move to the directory using << terminal >>

3. Next, type << ./biodragon.ps1 >>

4. You should see the desired files merged and saved properly

#>


# First we generate a list of all files whose names end with << fastq >> 

$allFastqFiles = Get-ChildItem -Name -Filter "*fastq*" 


function findUniqueGenomes {
 
                # initialize an empty array
                $allGenomeNames = @()

                foreach ($fileName in $allFastqFiles) {
                                $allGenomeNames += $fileName.Split("_")[6]
                } 
                return $allGenomeNames | Select-Object -Unique

}



# Generates the associated << FASTQ >> files for a particular genome
function allFilesForAGenome($genome) {
                $genomeRegExp = "*_" + $genome + "_*" 
                Get-ChildItem -Name  -Filter $genomeRegExp

}


# A function that returns the list of << R1 >> files associated with a genome
function combineAllR2ForGenome ($genome ) {


                $outputFileName = ($genome).ToString() + "_R2.txt"
                $filesForAGenome = allFilesForAGenome($genome)
                $R2FilesForAGenome = $filesForAGenome -like "*_R2_*"

                 
                foreach ($anR2File in $R2FilesForAGenome) {
                                Get-Content $anR2File | Out-File -Append -NoNewline $outputFileName

                }
}



# Here we call the << findUniqueFenomes >> function to store the unique genomes in another array.
$uniqueGenomeNames = findUniqueGenomes


# Show time, baby!
foreach ($genome in $uniqueGenomeNames) {
               
                combineAllR2ForGenome($genome)
}
