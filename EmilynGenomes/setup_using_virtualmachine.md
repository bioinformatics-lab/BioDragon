## Install VirtualBox 
This depends on the operating system you are using.

## Setting up VirtualBox image 

- Just double click on the `ITGE2017_RIO.ova` and it should be start virtualbox.
screenshot


- Click on `Import`
- 
screenshot

##### Tweak the settings of the virtual machine

- Before starting
    - Processor
    - RAM

- After starting
    -  Change the keyboard layout
    ```
        settings > keyboard > input layout > US Keyboard
    ```

##### Setup shared folder

```
sudo usermod -aG vboxsf $(whoami)

sudo mount -t vboxsf -o rw,uid=1000,gid=1000 Genesis ~/Desktop/Genesis/
```
##### Setup the virtualmachine for connecting with external Hard disk



##### Setup scala-ammonite shell

This is necessary since the steps of the analysis are written in the `scala` language.
```
mkdir -p ~/.ammonite && curl -L -o ~/.ammonite/predef.sc https://git.io/vHaKQ

sudo curl -L -o /usr/local/bin/amm https://git.io/vdNv2 && sudo chmod +x /usr/local/bin/amm && amm

```
