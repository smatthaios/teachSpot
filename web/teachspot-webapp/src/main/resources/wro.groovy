groups {
    'app.min' {
        css(minimize: true, "/styles/app.less")
        js(minimize: true, "/js/app.js")
    }

    'ace.min' {
        css(minimize: true, "/styles/ace.less")
    }

    'b.min' {
        css(minimize: true, "/styles/b.less")
    }

    'generic.min' {
        css(minimize: true, "/styles/generic.less")
    }

    'c.min' {
        js(minimize: true, "/js/c.js")
    }

    'messages.min' {
        js(minimize: true, "/js/messages.js")
    }
}