Set-Location /Users/eklavya/Projects/ProjectEklavya/Eklavya/Code/BioDragon/girls-in-science/test-files


$allFileNames =  Get-ChildItem -Name -Filter "*fastq*"

#  Get-ChildItem -Name -Filter "*LRu*.*R1*"

$allGenomeNames = @()
foreach ($fileName in $allFileNames) {
                $allGenomeNames += $fileName.Split("_")[6]

}

$uniqueGenomeNames =  $allGenomeNames | Select-Object -Unique


$RCodes = @("R1", "R2")



function makeFastqR1 ($file) {
                foreach ($genome in $allFileNames) {
                                if ($genome.Contains("_R1_")) {
                                               #Write-Host $genome 
                                               Get-Content $genome | Out-File -Append -NoNewline $file

                                }
                }

}

makeFastqR1 ("name.txt")

function makeFastqR2 () {
                
}
# print out proper genome name 

# print out the corresponding R-string 


## generate the corresponding name for the output-file




