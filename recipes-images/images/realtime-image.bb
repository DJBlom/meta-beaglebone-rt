# Base this image on core-image-minimal
include recipes-core/images/core-image-base.bb

# Include modules in rootfs
IMAGE_INSTALL += " \
	kernel-modules \
"

COMPATIBLE_MACHINE = "beaglebone-yocto"
IMAGE_FEATURES_append += " ssh-server-openssh"
export IMAGE_BASENAME = "realtime-image"
