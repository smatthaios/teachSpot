<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<a href="#" id="menu-toggler" class="menu-toggler"> <span class="menu-text"></span> </a>

<div class="sidebar" id="sidebar">
	<ul class="nav nav-list">
		<li>
			<a href="#!/mainboard"> <i class="icon-dashboard"></i> <span class="menu-text"><fmt:message key="general.link.mainboard" /></span> </a>
		</li>
		<li>
			<a href="/#" class="dropdown-toggle"> <i class="icon-briefcase"></i>
				<span class="menu-text"><fmt:message key="menu.link.scenarios" /></span> </a>
		</li>
	</ul>
	<!-- /.nav-list -->
	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-angle icon-angle-double-left" data-icon1="icon-angle-double-left" data-icon2="icon-angle-double-right"></i>
	</div>
</div>
