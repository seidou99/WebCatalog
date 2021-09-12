export class BaseDataObject {
  id: number;
}

export class Image extends BaseDataObject {
  imageName: string;
}

export class BaseDataObjectWithName extends BaseDataObject {
  name: string;

  constructor(name?: string) {
    super();
    if (name !== null && name !== undefined) {
      this.name = name;
    }
  }
}

export class FileWithDataUrl {
  file: File;
  dataUrl: string;


  constructor(file: File) {
    this.file = file;
  }
}
