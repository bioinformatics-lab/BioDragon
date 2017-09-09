<#

I'm assuming that you'd be using << Windows >> here

How to use this powershell script:

1. Save this file in the << EAI Genome_Emilyn >> folder - along with the basic genome files to be merged.

2. Move to the directory using << terminal >>

3. Next, type << ./biodragon.ps1 >>

4. You should see the desired files merged and saved properly

#>


# First we generate a list of all files whose names end with << fastq >> 

$allFastqFiles =  Get-ChildItem -Name -Filter "*fastq*" 


function findUniqueGenomes {



                Write-Host $allFastqFiles

<# 
                # initialize an empty array
$allGenomeNames = @()

foreach ($fileName in $allFastqFiles) {
                $allGenomeNames += $fileName.Split("_")[6]

} 
                return $allGenomeNames              


 #>

}




$uniqueGenomeNames =  $allGenomeNames | Select-Object -Unique


