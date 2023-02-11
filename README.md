# flatgeobuf-gt-poc

```
multipass launch jammy --cpus 2 --disk 20G --memory 8G --name ubuntugis
multipass mount /Users/stefan/sources ubuntugis:/home/ubuntu/sources
multipass mount /Users/stefan/tmp ubuntugis:/home/ubuntu/tmp
multipass shell ubuntugis

sudo apt-get update
sudo apt-get -y install gdal-bin libgdal-dev
```

```
multipass launch focal --cpus 2 --disk 20G --memory 8G --name ubuntugis20_04
multipass mount /Users/stefan/sources ubuntugis20_04:/home/ubuntu/sources
multipass mount /Users/stefan/tmp ubuntugis20_04:/home/ubuntu/tmp
multipass shell ubuntugis20_04

sudo apt-get update
sudo add-apt-repository ppa:ubuntugis/ubuntugis-unstable
sudo apt-get update
sudo apt-get -y install libgdal-dev gdal-bin libgdal-java 
```

graalpy -m pip install GDAL==3.4.1

python3 -m venv venv
source venv/bin/activate
python3 -m pip install --upgrade setuptools wheel
