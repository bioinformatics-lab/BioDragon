Set-Location /Users/eklavya/Projects/ProjectEklavya/Eklavya/Code/BioDragon/girls-in-science/test-files


$allFileNames =  Get-ChildItem -Name -Filter "*fastq*" 

#  Get-ChildItem -Name -Filter "*LRu*.*R1*"

$allGenomeNames = @()
foreach ($fileName in $allFileNames) {
                $allGenomeNames += $fileName.Split("_")[6]

}

$uniqueGenomeNames =  $allGenomeNames | Select-Object -Unique



$RCodes = @("_R1_", "_R2_")


foreach ($g in $uniqueGenomeNames) {
                #Get-ChildItem -Name -Filter $g | Select-String -Pattern "_R1_"
               Get-ChildItem -Name  -Filter "*G04868*"
}



function add9 
{
                Param(

    [parameter(position=0)]
    $arg1,
    [parameter(position=1)]
    $arg2

    )


                Write-Host $arg2
}

add9 1,9




function addNum () {

                #[System.Console]::WriteLine($arg1)

                #$arg1String = ($arg1).ToString()
                #[System.Console]::WriteLine($arg1String)
                #[System.Console]::WriteLine($arg2)


<#
                 Write-Host "arg1 : ", $arg1   -ForegroundColor red -BackgroundColor white 
                 Write-Host "arg2 : ", $arg2

                 Write-Host (9 + 9)

#>


                 Write-Host ($args[1] + $args[2])
 }

addNum(9,9)







$x = 9
($x).ToString()


# Convert this to two parameters! 

function makeFastqR1 ($file ,  $r) {
                                               Write-Host $r
 
<#                 foreach ($genome in $allFileNames) {
                                if ($genome.Contains($r)) {
                                               Write-Host $genome 
                                               #Get-Content $genome | Out-File -Append -NoNewline $file

                                }
                 } 

 #>
}

makeFastqR1 ("r1.txt", "_R1_")





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





function makeFastqR1 ($file ) {
                foreach ($genome in $allFileNames) {
                                if ($genome.Contains("_R1_")) {
                                               #Write-Host $genome 
                                               Get-Content $genome | Out-File -Append -NoNewline $file

                                }
                }

}

makeFastqR1 ("r1.txt")


##########
