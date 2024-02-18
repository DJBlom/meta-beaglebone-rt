FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE_beaglebone-yocto = "beaglebone-yocto"

LINUX_VERSION_beaglebone-yocto = "5.4.58"
LINUX_VERSION_EXTENSION = "-arod"

SRC_URI += "file://rt-5.4.58.cfg \
            file://patch-5.4.58-rt35.patch \
"
