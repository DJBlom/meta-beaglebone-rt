RECIPE_NAME="realtime-image"
# Base this image on core-image-minimal
include recipes-core/images/core-image-base.bb



COMPATIBLE_MACHINE = "beaglebone"
IMAGE_FEATURES:append = " ssh-server-openssh"

# Include modules in rootfs
IMAGE_INSTALL += " \
	kernel-modules"

inherit extrausers
USER_NAME = "technician"
PASSWD = "\$6\$arod\$tedpP2Y3YGW7LikkFhyh4qv2fvRmLsq6Z8x//U64AIVie.skknrb/b2SeZUbl3jIhJWFBIZsUSoH3ZTQzqV9a."

# Use EXTRA_USERS_PARAMS to add the user and set the password
#EXTRA_USERS_PARAMS:append = "
EXTRA_USERS_PARAMS = " \
    useradd -m ${USER_NAME}; \
    usermod -s /bin/sh -p '${PASSWD}' ${USER_NAME}; \
    usermod -aG sudo ${USER_NAME}; \
    usermod -p '${PASSWD}' root;"

# This needs to be extracted out to meta-arod distro layer
DISTRO_FEATURES:remove = "debug-tweaks"

export IMAGE_BASENAME = "realtime-image"
