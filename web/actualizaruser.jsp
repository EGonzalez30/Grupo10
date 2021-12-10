<%-- 
    Document   : actualizaruser
    Created on : 12-09-2021, 01:33:51 AM
    Author     : Pacheco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    HttpSession sesion = request.getSession();
    String usuario;
    RequestDispatcher rd;

    if (sesion.getAttribute("usuario") != null) {
        usuario = sesion.getAttribute("usuario").toString();
    } else {
        response.sendRedirect("ingresar.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>USUARIOS | Actualizar</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" href="recursos/bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="recursos/bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="recursos/bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="recursos/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="recursos/css/skins/_all-skins.min.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

                <!-- Google Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <header class="main-header">
                <!-- Logo -->
                <a href="inicio.jsp" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>O</b>RG</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>ORGANIGRAMA</b> Grupo 10</span>
                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>

                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <!-- Messages: style can be found in dropdown.less-->
                            <li class="dropdown messages-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-envelope-o"></i>
                                    <span class="label label-success">5</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="header">Tu Tienes 5 mensajes</li>
                                    <li>
                                        <!-- inner menu: contains the actual data -->
                                        <ul class="menu">
                                            <li><!-- start message -->
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="recursos/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Equipo de soporte
                                                        <small><i class="fa fa-clock-o"></i> 5 minutos</small>
                                                    </h4>
                                                    <p>¿Necesitas ayuda con tu equipo?</p>
                                                </a>
                                            </li>
                                            <!-- end message -->
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="recursos/img/user3-128x128.jpg" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Equipo de Diseño
                                                        <small><i class="fa fa-clock-o"></i> 2 horas</small>
                                                    </h4>
                                                    <p>Le adjuntamos algunos diseños de organigrama</p>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="recursos/img/user4-128x128.jpg" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Desarrolladores
                                                        <small><i class="fa fa-clock-o"></i> 8 horas</small>
                                                    </h4>
                                                    <p>Ideas para implememtar el código</p>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="recursos/img/user3-128x128.jpg" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Departamento de Ventas
                                                        <small><i class="fa fa-clock-o"></i> Ayer</small>
                                                    </h4>
                                                    <p>Las ventas han aumentado un 6%</p>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="recursos/img/user4-128x128.jpg" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Revisores
                                                        <small><i class="fa fa-clock-o"></i> Ayer</small>
                                                    </h4>
                                                    <p>Todo bien con el proyecto final</p>
                                                </a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="footer"><a href="#">Ver Todos los mensajes</a></li>
                                </ul>
                            </li>
                            <!-- Notifications: style can be found in dropdown.less -->
                            <li class="dropdown notifications-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-bell-o"></i>
                                    <span class="label label-warning">4</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="header">Tienes 4 notificaciones</li>
                                    <li>
                                        <!-- inner menu: contains the actual data -->
                                        <ul class="menu">
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-users text-aqua"></i> 3 nuevos usuarios
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-users text-red"></i> 5 nuevos empleados
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-shopping-cart text-green"></i> 15 nuevas ventas
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-user text-red"></i> Puedes cambiar tu nombre de usuario
                                                </a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="footer"><a href="#">Ver todo</a></li>
                                </ul>
                            </li>
                            <!-- Tasks: style can be found in dropdown.less -->
                            <li class="dropdown tasks-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-flag-o"></i>
                                    <span class="label label-danger">7</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="header">Tienes 7 tareas</li>
                                    <li>
                                        <!-- inner menu: contains the actual data -->
                                        <ul class="menu">
                                            <li><!-- Task item -->
                                                <a href="#">
                                                    <h3>
                                                        Diseñar los botones 
                                                        <small class="pull-right">20%</small>
                                                    </h3>
                                                    <div class="progress xs">
                                                        <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar"
                                                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                            <span class="sr-only">20% Completado</span>
                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                            <!-- end task item -->
                                            <li><!-- Task item -->
                                                <a href="#">
                                                    <h3>
                                                        Crear una nueva página .jsp
                                                        <small class="pull-right">40%</small>
                                                    </h3>
                                                    <div class="progress xs">
                                                        <div class="progress-bar progress-bar-green" style="width: 40%" role="progressbar"
                                                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                            <span class="sr-only">40% Completado</span>
                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                            <!-- end task item -->
                                            <li><!-- Task item -->
                                                <a href="#">
                                                    <h3>
                                                        Hacer todos los mantenimientos
                                                        <small class="pull-right">60%</small>
                                                    </h3>
                                                    <div class="progress xs">
                                                        <div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar"
                                                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                            <span class="sr-only">60% Completado</span>
                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                            <!-- end task item -->
                                            <li><!-- Task item -->
                                                <a href="#">
                                                    <h3>
                                                        Mejorar las vistas y diseños
                                                        <small class="pull-right">80%</small>
                                                    </h3>
                                                    <div class="progress xs">
                                                        <div class="progress-bar progress-bar-yellow" style="width: 80%" role="progressbar"
                                                             aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                            <span class="sr-only">80% Completado</span>
                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                            <!-- end task item -->
                                        </ul>
                                    </li>
                                    <li class="footer">
                                        <a href="#">Ver todas las tareas</a>
                                    </li>
                                </ul>
                            </li>
                            <!-- User Account: style can be found in dropdown.less -->
                            <li class="dropdown user user-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="recursos/img/user2-160x160.jpg" class="user-image" alt="User Image">
                                    <span class="hidden-xs">Erick González</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- User image -->
                                    <li class="user-header">
                                        <img src="recursos/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                                        <p>
                                            Erick González - PROGRA IV
                                            <small>Miembro desde Nov. 2021</small>
                                        </p>
                                    </li>
                                    <!-- Menu Footer-->
                                    <li class="user-footer">
                                        <div class="pull-right">
                                            <a href="ingresar.jsp" class="btn btn-default btn-flat">Salir</a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <!-- Control Sidebar Toggle Button -->
                            <li>
                                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="recursos/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p>ERICK PACHECO</p>
                            <a href="#"><i class="fa fa-circle text-success"></i> En Línea</a>
                        </div>
                    </div>
                    <!-- search form -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Buscar...">
                            <span class="input-group-btn">
                                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu" data-widget="tree">
                        <li class="header">BARRA DE NAVEGACIÓN</li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-dashboard"></i> <span>USUARIOS</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li class="active"><a href="insertuser.jsp"><i class="fa fa-circle-o"></i> Agregar Usuario</a></li>
                                <li><a href="#"><i class="fa fa-circle-o"></i> Ver Usuarios</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-users"></i>
                                <span>EMPLEADOS</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="index.jsp"><i class="fa fa-circle-o"></i> Agregar Empleado</a></li>
                                <li><a href="empleado?action=seleccionar"><i class="fa fa-circle-o"></i> Ver Empleados</a></li>
                                <li><a href="actualizar.jsp"><i class="fa fa-circle-o"></i> Actualizar Empleado</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>DEPARTAMENTOS</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="insertardepart.jsp"><i class="fa fa-circle-o"></i> Agregar Departamento</a></li>
                                <li><a href="mostrardepart.jsp"><i class="fa fa-circle-o"></i> Ver Departamento</a></li>
                                <li><a href="actualizardepart.jsp"><i class="fa fa-circle-o"></i> Actualizar Departamentos</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>CARGOS DE EMPLEADOS</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="cargo?action=irinsertar"><i class="fa fa-circle-o"></i> Agregar Cargo</a></li>
                                <li><a href="pages/tables/data.html"><i class="fa fa-circle-o"></i> Ver Los Cargos</a></li>
                                <li><a href="pages/tables/data.html"><i class="fa fa-circle-o"></i> Actualizar Cargo</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>NOMINAS</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pages/tables/simple.html"><i class="fa fa-circle-o"></i> Agregar Nomina</a></li>
                                <li><a href="pages/tables/data.html"><i class="fa fa-circle-o"></i> Ver NOMINAS</a></li>
                                <li><a href="pages/tables/data.html"><i class="fa fa-circle-o"></i> Actualizar Nomina</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>CONTRATOS</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pages/tables/simple.html"><i class="fa fa-circle-o"></i> Agregar Contrato</a></li>
                                <li><a href="pages/tables/data.html"><i class="fa fa-circle-o"></i> Ver Contratos</a></li>
                                <li><a href="pages/tables/data.html"><i class="fa fa-circle-o"></i> Actualizar Contrato</a></li>
                            </ul>
                        </li>                                                                     
                        <li class="header">ETIQUETAS</li>
                        <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Importantes</span></a></li>
                        <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Advertencias</span></a></li>
                        <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Información</span></a></li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>


            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Usuarios
                        <small>Actualizar usuario</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
                        <li class="active">Usuarios</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="container w-150 my-10">
                        <div class="row">
                            <div class="col-lg-20 mb-4">
                                <div class="text-center">
                                    <h2>ACTUALIZAR USUARIO</h2>
                                </div>
                                <form action="usuario?action=actualizar" method="POST">
                                    <c:forEach items="${lista}" var="ver">  
                                        <div class="form-group has-feedback mb-4">
                                            <input type="number" class="form-control" name="id" placeholder="ID USUARIO" value="${ver.id}">
                                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                        </div>
                                            
                                        <div class="form-group has-feedback mb-4">
                                            <input type="text" class="form-control" name="nombre" placeholder="NOMBRE" value="${ver.nombre}">
                                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                        </div>

                                        <div class="form-group has-feedback mb-4">
                                            <input type="text" class="form-control" name="apellido" placeholder="APELLIDO" value="${ver.apellido}">
                                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                        </div>

                                        <div class="form-group has-feedback mb-4">
                                            <input type="text" class="form-control" name="usuario" placeholder="USUARIO" value="${ver.usuario}">
                                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                        </div>

                                        <div class="form-group has-feedback mb-4">
                                            <input type="text" class="form-control" name="clave" placeholder="CLAVE" value="${ver.clave}">
                                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                        </div>
                                        <button class="btn bg-blue btn-primary btn-block" type="submit">ENVIAR</button>
                                    </c:forEach>
                                </form>
                                ${msg}
                                <div class="col s12 m6 l6">
                                    <a class="btn bg-green btn-primary btn-block" href="usuario?action=seleccionar">MOSTRAR</a>
                                </div>
                            </div>
                        </div>                                               
                    </div>
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Version</b> 2.4.0
                </div>
                <strong>Copyright &copy; USAM-2021 <a href="https://adminlte.io">PROGRAMACION IV</a>.</strong> Todos los
                derechos reservados.
            </footer>

            <!-- Control Sidebar -->
            <aside class="control-sidebar control-sidebar-dark">
                <!-- Create the tabs -->
                <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
                    <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
                    <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
                </ul>
                <!-- Tab panes -->
                <div class="tab-content">
                    <!-- Home tab content -->
                    <div class="tab-pane" id="control-sidebar-home-tab">
                        <h3 class="control-sidebar-heading">Actividad Reciente</h3>
                        <ul class="control-sidebar-menu">
                            <li>
                                <a href="javascript:void(0)">
                                    <i class="menu-icon fa fa-birthday-cake bg-red"></i>

                                    <div class="menu-info">
                                        <h4 class="control-sidebar-subheading">Cumpleaños de Erick</h4>

                                        <p>30 de noviembre</p>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <i class="menu-icon fa fa-user bg-yellow"></i>

                                    <div class="menu-info">
                                        <h4 class="control-sidebar-subheading">Sandor ha actualizado su foto de perfil</h4>

                                        <p>Nuevo telefono +5036186-6917</p>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

                                    <div class="menu-info">
                                        <h4 class="control-sidebar-subheading">Emely creo un nuevo correo</h4>

                                        <p>emely247@gmail.com</p>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <i class="menu-icon fa fa-file-code-o bg-green"></i>

                                    <div class="menu-info">
                                        <h4 class="control-sidebar-subheading">Trabajo realizado</h4>

                                        <p>Tiempo de ejecución 10 segundos</p>
                                    </div>
                                </a>
                            </li>
                        </ul>
                        <!-- /.control-sidebar-menu -->

                        <h3 class="control-sidebar-heading">Progreso de tareas</h3>
                        <ul class="control-sidebar-menu">
                            <li>
                                <a href="javascript:void(0)">
                                    <h4 class="control-sidebar-subheading">
                                        Diseño de plantillas personalizadas 
                                        <span class="label label-danger pull-right">70%</span>
                                    </h4>

                                    <div class="progress progress-xxs">
                                        <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <h4 class="control-sidebar-subheading">
                                        Actualizar Empleados
                                        <span class="label label-success pull-right">95%</span>
                                    </h4>

                                    <div class="progress progress-xxs">
                                        <div class="progress-bar progress-bar-success" style="width: 95%"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <h4 class="control-sidebar-subheading">
                                        Implementación de Cargos
                                        <span class="label label-warning pull-right">50%</span>
                                    </h4>

                                    <div class="progress progress-xxs">
                                        <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:void(0)">
                                    <h4 class="control-sidebar-subheading">
                                        Marco de trabajo de fondo
                                        <span class="label label-primary pull-right">68%</span>
                                    </h4>

                                    <div class="progress progress-xxs">
                                        <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
                                    </div>
                                </a>
                            </li>
                        </ul>
                        <!-- /.control-sidebar-menu -->

                    </div>
                    <!-- /.tab-pane -->
                    <!-- Stats tab content -->
                    <div class="tab-pane" id="control-sidebar-stats-tab">Contenido de la pestaña estadística</div>
                    <!-- /.tab-pane -->
                    <!-- Settings tab content -->
                    <div class="tab-pane" id="control-sidebar-settings-tab">
                        <form method="post">
                            <h3 class="control-sidebar-heading">Configuración General</h3>

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Uso del panel de informes
                                    <input type="checkbox" class="pull-right" checked>
                                </label>

                                <p>
                                    Informacion de configuracion
                                </p>
                            </div>
                            <!-- /.form-group -->

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Permitir redicción de correo
                                    <input type="checkbox" class="pull-right" checked>
                                </label>

                                <p>
                                    Otros conjuntos de opciones disponibles
                                </p>
                            </div>
                            <!-- /.form-group -->

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Exponer el nombre de autor en las entradas
                                    <input type="checkbox" class="pull-right" checked>
                                </label>

                                <p>
                                    Permitir que el usuario muestre su nombre
                                </p>
                            </div>
                            <!-- /.form-group -->

                            <h3 class="control-sidebar-heading">Configración de chat</h3>

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Mostrarme en linea
                                    <input type="checkbox" class="pull-right" checked>
                                </label>
                            </div>
                            <!-- /.form-group -->

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Desactivar las notificaciones
                                    <input type="checkbox" class="pull-right">
                                </label>
                            </div>
                            <!-- /.form-group -->

                            <div class="form-group">
                                <label class="control-sidebar-subheading">
                                    Borrar el chat del historial
                                    <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
                                </label>
                            </div>
                            <!-- /.form-group -->
                        </form>
                    </div>
                    <!-- /.tab-pane -->
                </div>
            </aside>
            <!-- /.control-sidebar -->
            <!-- Add the sidebar's background. This div must be placed
                 immediately after the control sidebar -->
            <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->

        <!-- jQuery 3 -->
        <script src="recursos/bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="recursos/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- Slimscroll -->
        <script src="recursos/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>      
        <!-- FastClick -->
        <script src="recursos/bower_components/fastclick/lib/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="recursos/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="recursos/js/demo.js"></script>
    </body>
</html>
