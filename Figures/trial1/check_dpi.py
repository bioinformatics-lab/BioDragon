import glob

from PIL import Image

#files = glob.glob("*.png")

for f in files:
    name = f.split(".")[0]
    im = Image.open(f)
    im.info()

im = Image.open('./Figure2')
print(im.info['dpi'])
