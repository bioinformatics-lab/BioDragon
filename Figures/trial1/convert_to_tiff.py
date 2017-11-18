import glob

from PIL import Image

dpi_value = 2000  # default value
files = glob.glob("*.png")

for f in files:
    name = f.split(".")[0]
    im = Image.open(f)
    im.save(name, "tiff", dpi=(dpi_value, dpi_value))
