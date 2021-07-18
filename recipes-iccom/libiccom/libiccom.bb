inherit cmake

LICENSE = "MPLv2"
SUMMARY = "Bosch libiccom"

SRC_URI = "git://github.com/Bosch-SW/libiccom.git;protocol=https;branch=main"
SRCREV = "360c017f6d20eb37928d48520f483efcb4ca52a6"
PV = "1.0.0"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=9741c346eef56131163e13b9db1241b3"

SRC_URI += "\
    file://0001-Add-VERSION-pnd-SOVERSION-to-CMakeLists.txt.patch \
    file://0002-Change-netlink-family-ID-NETLINK_ICCOM.patch \
"
  
