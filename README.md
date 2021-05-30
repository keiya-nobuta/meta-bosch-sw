How to Build
=================

1) Checkout branch that matches poky version, for example:

```
$ git checkout hardknott
```

2) Before bitbake, check the kernel configuration to see if CONFIG_SPI=y,

```
$ bitbake -c menuconfig linux-yocto
```

check below:

```
Device Drivers -->
  [*] SPI support
```

3) type bitbake command

```
$ bitbake -c bosch-iccom
```

Enablement
===============

1) Bosch iccom current implementation depends on symspi,
   and symspi needs Device-Tree nodes, for example:

```
symspi1: symspi1@0 {
	reg = <0>;      /* CE0 */
	#address-cells = <1>;
	#size-cells = <0>;
	spi-max-frequency = <125000000>;
	compatible = "bosch,symspi1";
	symspi-hsk-out-gpios = <&gpio 17 GPIO_ACTIVE_HIGH>;
	symspi-hsk-in-gpios = <&gpio 27 GPIO_ACTIVE_HIGH>;
};
```

