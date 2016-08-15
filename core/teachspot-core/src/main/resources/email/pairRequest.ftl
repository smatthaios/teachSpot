<!-- DO NOT FORMAT THIS FILE -->
<#compress>
<table width="600" align="center" cellpadding="0" cellspacing="0" style="border:1px solid #ccc;background:#fff;font-family: Verdana">
	<tbody>
		<tr>
			<#--<td width="150" style="padding:10px 0px 5px 20px"><img height="80" src="http://localhost:8081/teachspot/assets/img/logo.png" align="absmiddle" title="TeachSpot" border="0"></td>-->
			<td width="350" style="padding:10px 5px; vertical-align: bottom"><span style="font-size: 25px; color: #38447D; font-family: Verdana"><b>TeachSpot</b></span></td>
		</tr>
		<tr>
			<td colspan="2" style="margin:0 20px"><hr noshade="" color="#cccccc" style="margin:0 20px"></td>
		</tr>
		<tr>
			<td colspan="2" style="font-size:14px;margin:0px;color:#666;padding:20px 20px 0px">Hello ${firstName} ${lastName},</td>
		</tr>
		<tr>
			<td style="color:#666;font-size:12px;line-height:1.2em;padding:0 20px" colspan="2">
				A pair request has been created for you.<br><br>
                <br>Press <a href="${pairRequestUrl}${profileId}/pairAccept?token=${token}">here</a> If you want to enroll to the ${lessonName}. <br><br>
				Best Regards,<br>
                TeachSpot Team
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" style="color:#666;font-size:10px;padding:0 20px"><br> <br><div>Please do not reply to this email. This mailbox is not monitored and you will not receive a response.</div></td>
		</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
	</tbody>
</table>
</#compress>