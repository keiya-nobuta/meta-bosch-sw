SUMMARY = "Bosch iccom drivers"
inherit module

LICENSE = "GPLv2"

SRC_URI = "\
    git://github.com/Bosch-SW/linux-iccom.git;protocol=https;name=iccom \
    git://github.com/Bosch-SW/linux-symspi.git;protocol=https;destsuffix=git/linux-symspi;name=symspi \
    git://github.com/Bosch-SW/linux-full-duplex-interface.git;destsuffix=git/linux-full-duplex-interface;branch=main;protocol=https;name=header \
    file://Kbuild \
    file://Makefile \
    "

LIC_FILES_CHKSUM = "\
    file://LICENSE.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://linux-symspi/LICENSE.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://linux-full-duplex-interface/LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    "

SRC_URI += "\
    file://0001-Change-various-to-match-v5.4.y.patch \
    file://0002-Fix-Kconfig.patch \
    file://0003-Change-to-use-atomic_-instead-of-built-in-functions.patch \
    file://0004-Kconfig-update-for-kbuild-v5.8-2.patch \
    file://0005-Change-various-to-match-v5.8.y.patch \
    file://0006-Add-transport-layer-dumper.patch \
    file://0007-Add-definitions-to-build-outside-the-kernel-tree.patch \
    file://symspi-0001-Change-various-to-match-v5.4.y.patch \
    file://symspi-0002-Change-to-use-atomic_-instead-of-built-in-functions.patch \
    file://symspi-0003-Fix-SYMSPI_ERROR_TYPES_COUNT.patch \
    file://symspi-0004-include-linux-of.h.patch \
    file://symspi-0005-Change-various-to-match-v5.8.y.patch \
    "


SRCREV_iccom = "6abd5ca9ff80f4bdffdec18776c30725b7e9d77b"
SRCREV_symspi = "60bc5a1aa5c8581b6ac98e69dcd57b3b083fb016"
SRCREV_header = "29cab9e103367d86ed728696eebd06502ae55530"

S = "${WORKDIR}/git"

do_compile_prepend() {
    cp -r src iccom
    cp -r linux-symspi/src symspi
    cp -r linux-full-duplex-interface/headers full_duplex_interface
    cp -r ${WORKDIR}/Kbuild .
    cp -r ${WORKDIR}/Makefile .
}
