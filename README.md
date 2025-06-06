# IS_PROYECTO_FINAL

La aplicacion spring se reinicia varias veces al ejecutar  - docker-compose up
ya que el contenedor de mysql se tarda en inicializar lo cual hace que la app de spring de error de conexion.
Se le agrego un  - restart: always 
al contenedor de spring para que se ejecute hasta que el contenedor de mysql este disponible.
