Set-Location /Users/eklavya/Projects/ProjectEklavya/Eklavya/Code/BioDragon/girls-in-science/test-files


$allFileNames =  Get-ChildItem -Name -Filter "*fastq*"

#  Get-ChildItem -Name -Filter "*LRu*.*R1*"

$allGenomeNames = @()
foreach ($fileName in $allFileNames) {
                $allGenomeNames += $fileName.Split("_")[6]

}

$uniqueGenomeNames =  $allGenomeNames | Select-Object -Unique



$RCodes = @("_R1_", "_R2_")

function makeFastqR1 ($file ) {
                foreach ($genome in $allFileNames) {
                                if ($genome.Contains("_R1_")) {
                                               #Write-Host $genome 
                                               Get-Content $genome | Out-File -Append -NoNewline $file

                                }
                }

}

#makeFastqR1 ("r1.txt")


function makeFastqR2 ($file ) {
                foreach ($genome in $allFileNames) {
                                if ($genome.Contains("_R2_")) {
                                               #Write-Host $genome 
                                               Get-Content $genome | Out-File -Append -NoNewline $file

                                }
                }

}

makeFastqR2 ("r2.txt")



# print out proper genome name 

# print out the corresponding R-string 


## generate the corresponding name for the output-file




