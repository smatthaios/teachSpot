<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div id="modal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title"><i class="icon-exclamation-sign cred"></i> <span id="modalTitle">Modal title</span></h3>
            </div>
            <div class="modal-body" id="modal-body">
                <p>One fine body&hellip;</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" ng-click="okMethod()"><fmt:message key="general.button.submit" /></button>
                <button type="button" class="btn btn-primary" data-dismiss="modal"><fmt:message key="common.button.close" /></button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>