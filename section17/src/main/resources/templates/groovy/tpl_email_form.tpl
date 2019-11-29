yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
    head {
        meta('http-equiv':'"Content-Type" content="text/html; charset=utf-8"')
        title('Person List')
        script(src: '//code.jquery.com/jquery-1.11.1.min.js'){}
        link(rel: 'stylesheet', href: '//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css')
        script(src: '//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js'){}
        
    }
    body {
    div ( class: 'container'){
       div ( class : 'row col-md-6 col-md-offset-2 custyle') {
        h2 ('Inbox')
         
		 form (class:'form', action :'/farm/email', method :'POST') {
                div (class:'controls controls-row') {
                    label("To: ")
                    input (id:'to', name:'name', type:'email', class:'span3', placeholder:'xxxxx@yahoo.com')
                    br()
                
                }
                
                div (class:'controls controls-row') {
                	label("Subject: ")
                	input (id:'subject', name:'subject', type:'text', class:'span3', placeholder:'Name')
                	br()
                }
                div (class : 'controls controls-row') {
                	label("Message: ")
                    textarea (id:'comment', name:'comment', class:'span6', placeholder:'Comment', rows:'5'){}
                    br()
                    br()
                }
                  
                div (class :'controls controls-row') {
                    input (id:'contact-submit', type:'submit', value: 'Send Comment', class:'btn btn-primary input-medium pull-left') 
                }
             }
            
               
          }
        
      }
    }
}