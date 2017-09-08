Set-Location /Users/eklavya/Projects/ProjectEklavya/Eklavya/Code/BioDragon/girls-in-science/test-files


$allFileNames =  Get-ChildItem -Name -Filter "*fastq*"

#  Get-ChildItem -Name -Filter "*LRu*.*R1*"

$allGenomeNames = @()
foreach ($fileName in $allFileNames) {
                $allGenomeNames += $fileName.Split("_")[6]

}

$uniqueGenomeNames =  $allGenomeNames | Select-Object -Unique


$RCodes = @("R1", "R2")



# print out proper genome name 

# print out the corresponding R-string 




## generate the corresponding name for the output-file

$arr = Get-ChildItem -Filter *R1* -Name


foreach ($a in $arr) {
                Get-Content $a | Out-File -Append -NoNewline out.txt

}





