document.addEventListener('DOMContentLoaded', init);

function init() {
	console.log('DOM Content successfully loaded');
}

function getEditorContent() {
	let form = document.getElementById('textEditorForm');
	let editorFullRawText = document.getElementById('editor').innerHTML;
	/* 46 is the substring starting point as it's the first part of quill editor innerHTML
	*  length - 314 deletes the end points of quill editor innerHTML.
	*  IMPORTANT: in case of Quill API update, it will be necessary to check if these values 
	*  need to be updated also.
	*/
	let editorRawText = editorFullRawText.substring(46, editorFullRawText.length - 314);
	document.getElementById('rawText').value = editorRawText;

	form.submit();
	
}

function saveEditorContent() {
	let form = document.getElementById('textEditorForm');
	
	let editorFullRawText = document.getElementById('editor').innerHTML;
	/* 46 is the substring starting point as it's the first part of quill editor innerHTML
	*  length - 314 deletes the end points of quill editor innerHTML.
	*  IMPORTANT: in case of Quill API update, it will be necessary to check if these values 
	*  need to be updated also.
	*/
	let editorRawText = editorFullRawText.substring(46, editorFullRawText.length - 314);
	document.getElementById('rawText').value = editorRawText;
	
	form.setAttribute('action', 'save');
	alert("You will find the file on your desktop");
	form.submit();
}