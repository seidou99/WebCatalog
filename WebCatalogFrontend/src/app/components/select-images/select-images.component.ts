import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FileWithDataUrl} from '../../model/base-data-object';

@Component({
  selector: 'app-select-images',
  templateUrl: './select-images.component.html',
  styleUrls: ['./select-images.component.css']
})
export class SelectImagesComponent implements OnInit {
  mainImage: FileWithDataUrl;
  selectedImages: Array<FileWithDataUrl> = [];

  @Output()
  imagesChanged = new EventEmitter<Array<File>>();

  constructor() {
  }

  ngOnInit(): void {
  }

  onImagesChanged(event): void {
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

  onMainImageChanged(event): void {
    const files = event.target.files as FileList;
    if (files.length !== 1) {
      return;
    }
    this.mainImage = new FileWithDataUrl(files.item(0));
    const fileReader = new FileReader();
    fileReader.readAsDataURL(this.mainImage.file);
    fileReader.onload = (fileReaderEvent) => {
      this.mainImage.dataUrl = fileReaderEvent.target.result as string;
    };
  }

  delete(index: number): void {
    this.selectedImages.splice(index, 1);
  }

  deleteMainImage(): void {
    this.mainImage = null;
  }

}

export class SelectImagesResult {
  mainImage: File;
  images: Array<File>;
}
