FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SUMMARY = "Hello world program to verify build"
DESCRIPTION = "Verifies that the build was successful and that we can install programs"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "app.service"

SRC_URI = "file://helloworld.c \
           file://app.service \
"
FILES_${PN} += "${systemd_unitdir}/system/app.service"

S = "${WORKDIR}/build/"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/helloworld.c -o ${S}/app
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/app ${D}${bindir}
    install -d ${D}/${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/app.service ${D}/${systemd_unitdir}/system
}
