import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FileWithDataUrl} from '../../model/base-data-object';

@Component({
  selector: 'app-select-images',
  templateUrl: './select-images.component.html',
  styleUrls: ['./select-images.component.css']
})
export class SelectImagesComponent implements OnInit {
  selectedImages: Array<FileWithDataUrl> = [];

  @Output()
  imagesChanged = new EventEmitter<Array<File>>();

  constructor() {
  }

  ngOnInit(): void {
  }

  onFileChanged(event): void {
    const files = event.target.files as FileList;
    for (let i = 0; i < files.length; i++) {
      const image = new FileWithDataUrl(files.item(i));
      this.selectedImages.push(image);
      const fileReader = new FileReader();
      fileReader.readAsDataURL(image.file);
      fileReader.onload = (fileReaderEvent) => {
        image.dataUrl = fileReaderEvent.target.result as string;
      };
    }
    this.imagesChanged.emit(this.selectedImages.map(img => img.file));
  }

  delete(index: number): void {
    this.selectedImages.splice(index, 1);
  }

}
