import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FileWithDataUrl, Image} from "../../model/base-data-object";
import {ApiConstants} from "../../Constants";

@Component({
  selector: 'app-edit-product-images',
  templateUrl: './edit-product-images.component.html',
  styleUrls: ['./edit-product-images.component.css']
})
export class EditProductImagesComponent implements OnInit {

  @Input() oldMainImage: Image;
  @Input() oldImages: Array<Image>;
  mainImage: FileWithDataUrl;
  selectedImages: Array<FileWithDataUrl> = [];
  IMAGES_API_URL = ApiConstants.IMAGES_API_URL;

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

  deleteOldImage(index: number): void {
    this.oldImages.splice(index, 1);
  }

  deleteMainImage(): void {
    this.mainImage = null;
  }

  deleteOldMainImage(): void {
    this.oldMainImage = null;
  }

}
