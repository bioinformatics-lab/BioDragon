### How to use the script

A simple usage can be checked from here
https://vimeo.com/233094262





### 10 September 2017


We have changed the implementation to just run the exact commands which She enters manually.

######
Resource for installing `ruby-2.3` in `Ubuntu-14.04`

https://www.brightbox.com/blog/2016/01/06/ruby-2-3-ubuntu-packages/



I've summarised the commands here 

```
$ sudo apt-add-repository ppa:brightbox/ruby-ng
$ sudo apt-get update
$ sudo apt-get install ruby2.3 ruby2.3-dev

```


Then check if ruby is installed successfully  

```
$ ruby --version

```

The output should be similar to ( just check ruby 2.3 in beginning) 
`ruby 2.3.3p222 (2016-11-21 revision 56859) [x86_64-darwin16]`


###### Instructions for running the ruby script for automated file conversions and merging


 1. Save this file in the << EAI Genome_Emilyn >> folder - along with the basic genome files to be merged.

 2. Move to the directory using << terminal >>

 3. Next, type << ruby biodragon.rb >>

 4. You should see the desired files merged and saved properly





### 9 September 2017

The `script` is located here

https://github.com/abhi18av/BioDragon/blob/master/girls-in-science/test-files/biodragon.ps1
