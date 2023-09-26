document.addEventListener('DOMContentLoaded', init);

function init() {
	console.log('DOM Content successfully loaded');
}

function getEditorContent() {
	let editorFullRawText = document.getElementById('editor').innerHTML;
	alert(editorFullRawText);
	/* 46 is the substring starting point as it's the first part of quill editor innerHTML
	*  length - 314 deletes the end points of quill editor innerHTML.
	*  IMPORTANT: in case of Quill API update, it will be necessary to check if these values 
	*  need to be updated also.
	*/
	let editorRawText = editorFullRawText.substring(46, editorFullRawText.lastIndexOf('</p>') + 4);
	document.getElementById('rawText').value = editorRawText;
	alert(editorRawText);
	document.getElementById('textEditorForm').submit();
	
}