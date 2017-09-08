Set-Location /Users/eklavya/Projects/ProjectEklavya/Eklavya/Code/BioDragon/girls-in-science/test-files



# print out proper genome name 
# print out the corresponding R-string 

## generate the corresponding name for the output-file

$arr = Get-ChildItem -Filter *R1* -Name


foreach ($a in $arr) {
                Get-Content $a | Out-File -Append -NoNewline out.txt
                #Write-Host $a

}






get-help Add-Content