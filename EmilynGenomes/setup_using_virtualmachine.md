## Install VirtualBox 
This depends on the operating system you are using.

## Setting up VirtualBox image 

- Just double click on the `ITGE2017_RIO.ova` and it should be start virtualbox.
screenshot


- Click on `Import`

![screenshot](./001.png)
  ![screenshot](./002.png)
Re
##### Tweak the settings of the virtual machine

- Before starting
    - Processor
    Set it to `green` levels like so
    ![screenshot](./003.png)

    - RAM
    Set it to `green` levels like so
  ![screenshot](./004.png)
- After starting
    -  Change the keyboard layout
     ![screenshot](./008.png)
    ```
        settings > region and language > input layout > US Keyboard
    ```

- Power options 

```
settings -> power options -> blank screen -> never 
```

- Install VirtualBox guest additions
 
Go to the top menu, 
```
Devices -> Insert Guest additions CD image 
```
 
 ![screenshot](./009.png)
  ![screenshot](./010.png)
   ![screenshot](./011.png)
   
##### Setup shared folder


  ![screenshot](./005.png)
  ![screenshot](./006.png)
 

From inside the virtualbox image, run these commands in the terminal
```
sudo usermod -aG vboxsf $(whoami)

sudo mount -t vboxsf -o rw,uid=1000,gid=1000 BioDragon ~/Desktop/BioDragon/

```

Now you can see a `sf_BioDragon` folder in the virtualbox image

##### Setup the virtualmachine for connecting with external Hard disk



##### Setup scala-ammonite shell

This is necessary since the steps of the analysis are written in the `scala` language.
```
mkdir -p ~/.ammonite && curl -L -o ~/.ammonite/predef.sc https://git.io/vHaKQ

sudo curl -L -o /usr/local/bin/amm https://git.io/vdNv2 && sudo chmod +x /usr/local/bin/amm && amm

```
