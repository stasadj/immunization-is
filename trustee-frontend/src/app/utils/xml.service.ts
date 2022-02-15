import { Injectable } from '@angular/core';
import * as xml2js from 'xml2js';

@Injectable({
    providedIn: 'root',
})
export class XmlService {
    public parse(xml: string): any {
        let convertedObject: any;
        const parser = new xml2js.Parser({ strict: false, trim: true });
        parser.parseString(xml, (err: any, result: any) => {
            let firstKey = Object.keys(result)[0];
            convertedObject = result[firstKey];
        });
        return convertedObject;
    }
}
