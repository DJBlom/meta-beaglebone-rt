FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE:beaglebone-yocto = "beaglebone-yocto"
LINUX_VERSION_beaglebone-yocto = "6.6.21"
LINUX_VERSION_EXTENSION = "-arod"

SRC_URI += "file://realtime.cfg \
            file://patch-6.6.22-rt27.patch"

# Bad Idea, But It Works
ERROR_QA:remove = "patch-status"
