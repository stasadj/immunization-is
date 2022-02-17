import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GradjaninPageComponent } from './gradjanin-page.component';

describe('GradjaninPageComponent', () => {
  let component: GradjaninPageComponent;
  let fixture: ComponentFixture<GradjaninPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GradjaninPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GradjaninPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
