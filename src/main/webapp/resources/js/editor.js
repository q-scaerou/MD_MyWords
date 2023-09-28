document.addEventListener('DOMContentLoaded', init);

function init() {
	console.log('DOM Content successfully loaded');
}

function getEditorContent() {
	// Getting current number of pages
	let nbPage = document.getElementById('nbPage');
	let nbPageValue = nbPage.value;
	
	let form = document.getElementById('textEditorForm');
	let editorFullRawText = document.getElementById('editor').innerHTML;
	
	/* 46 is the substring starting point as it's the first part of quill editor innerHTML
	*  length - 314 deletes the end points of quill editor innerHTML.
	*  IMPORTANT: in case of Quill API update, it will be necessary to check if these values 
	*  need to be updated also.
	*/
	let editorRawText = editorFullRawText.substring(46, editorFullRawText.length - 314);
	document.getElementById('rawText' + nbPageValue).value = editorRawText;

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
	document.getElementById('rawText1').value = editorRawText;
	
	// TODO deal with multi page storage
	
	form.setAttribute('action', 'save');
	alert("You will find the file on your desktop");
	form.submit();
}

function addPage() {
	// Getting current number of pages
	let nbPage = document.getElementById('nbPage');
	let nbPageValue = nbPage.value;
	
	// Dealing with the note text as usual (see getEditorContent() method)
	let editor = document.getElementById('editor');
	let editorFullRawText = editor.innerHTML;
	let previousPage = document.getElementById('rawText' + nbPageValue);
	let editorRawText = editorFullRawText.substring(46, editorFullRawText.length - 314);
	previousPage.value = editorRawText;
	
	// Update nb of pages in notebook
	nbPageValue++;
	nbPage.value = nbPageValue;
	
	// Create new hidden input to store the text of the new page
	let newHiddenInput = document.createElement('input');
	let newId = 'rawText' + nbPageValue;
	
	newHiddenInput.setAttribute('id', newId);
	newHiddenInput.setAttribute('name', newId);
	newHiddenInput.setAttribute('type', 'hidden');
	newHiddenInput.setAttribute('value', '');
	previousPage.parentNode.insertBefore(newHiddenInput, previousPage.nextSibling);
	
	
	editor.firstChild.innerHTML = 'Page ' + nbPageValue;
	editor.firstChild.setAttribute('contenteditable', true);
	
}


