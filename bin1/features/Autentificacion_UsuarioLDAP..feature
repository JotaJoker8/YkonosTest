@Ykonos
Feature: Autentificación GIMD Ykonos de un usuario LDAP
	Al insertar un usuario y contraseña en la pantalla de login
	y el usuario existe en el LDAP
	y el usuario existe registrado en el sistema GIMD Ykonos
	quiero que se valide el usuario 
	para acceder a GIMD Ykonos

Background
  Given Sistema GIMD Ykonos activo
  And Tener preparado un usuario con categoria asociada (LDAP)

  @Test_Autentificacion_UsuarioNoExisteGIMD
	Scenario: Al insetar un usuario y contraseña válido de un usuario que pertenece a LDAP y tiene información de rol y DG y CMBD en LDAP pero no esta registrado en GIMD Ykonos, se valida el usuario y se registra el usuario en el GIMD Ykonos
	  Given tenemos un usuario LDAP
	  And el usuario tiene definido DG
	  And el usuario tiene definido CMBD
	  And el usuario no existe en GIMD Ykonos
	  When se indica el usuario correctamente 
	  And se indica la contraseña correctamente
	  And se da al botón "Acceder"
	  Then se registra el paciente en el GIMD Ykonos (tabla USERS)
	  And se accede a la pantalla para seleccionar el centro
	  And se indica el nombre del usuario
	  And se muestra el rol del usuario
	  And se muestra la especialidad (CMBD) del usuario 
	  And no se muestra ningun centro asociado al usuario
