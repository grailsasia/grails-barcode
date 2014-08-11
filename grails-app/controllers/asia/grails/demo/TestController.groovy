package asia.grails.demo

import org.krysalis.barcode4j.impl.code39.Code39Bean

class TestController {
    def barcode4jService

    def web() {
    }

    def showBarcode(String barcode) {
        def generator = new Code39Bean()
        generator.height = 6
        generator.fontSize = 2

        renderBarcodePng(generator, barcode)
    }

    def download() {
        response.contentType = 'application/pdf'
        response.setHeader("Content-disposition", "attachment; filename=\"barcode-example.pdf\"")

        def generator = new Code39Bean()
        generator.height = 6
        generator.fontSize = 2

        def items = []
        (101..105).each { number->
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            barcode4jService.render(generator, number.toString(), bos, "image/png")
            items << [number:number, bytes:bos.toByteArray()]
        }

        renderPdf (template:'download', model:[items:items])
    }

}
