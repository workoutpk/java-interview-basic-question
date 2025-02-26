I'll provide a comprehensive overview of the types of Angular directives with code examples:

1. **Component Directives**
```typescript
@Component({
  selector: 'app-user-profile',
  template: `<div>User Profile Component</div>`
})
export class UserProfileComponent {}
```

2. **Structural Directives**
```typescript
// Built-in Structural Directives
<div *ngIf="isVisible">Conditionally Rendered</div>
<div *ngFor="let item of items">List Item</div>
<div *ngSwitch="condition">
  <div *ngSwitchCase="'case1'">Case 1 Content</div>
  <div *ngSwitchDefault>Default Content</div>
</div>
```

3. **Attribute Directives**
```typescript
// Built-in Attribute Directives
<div [ngClass]="{'active': isActive}">Conditional Class</div>
<div [ngStyle]="{'color': textColor}">Styled Element</div>
<div [hidden]="isHidden">Conditionally Hidden</div>
```

4. **Custom Structural Directive**
```typescript
@Directive({
  selector: '[appUnless]'
})
export class UnlessDirective {
  private hasView = false;

  constructor(
    private templateRef: TemplateRef<any>,
    private viewContainer: ViewContainerRef
  ) {}

  @Input() set appUnless(condition: boolean) {
    if (!condition && !this.hasView) {
      this.viewContainer.createEmbeddedView(this.templateRef);
      this.hasView = true;
    } else if (condition && this.hasView) {
      this.viewContainer.clear();
      this.hasView = false;
    }
  }
}

// Usage
<div *appUnless="condition">Show when condition is false</div>
```

5. **Custom Attribute Directive**
```typescript
@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {
  @Input('appHighlight') highlightColor: string = 'yellow';

  constructor(private el: ElementRef) {}

  @HostListener('mouseenter') onMouseEnter() {
    this.highlight(this.highlightColor);
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.highlight(null);
  }

  private highlight(color: string | null) {
    this.el.nativeElement.style.backgroundColor = color;
  }
}

// Usage
<div appHighlight="lightblue">Hover me</div>
```

6. **Renderer2 Directive**
```typescript
@Directive({
  selector: '[appBetterHighlight]'
})
export class BetterHighlightDirective {
  constructor(
    private elRef: ElementRef, 
    private renderer: Renderer2
  ) {}

  @HostListener('mouseenter') mouseover() {
    this.renderer.setStyle(
      this.elRef.nativeElement, 
      'background-color', 
      'blue'
    );
  }

  @HostListener('mouseleave') mouseleave() {
    this.renderer.setStyle(
      this.elRef.nativeElement, 
      'background-color', 
      'transparent'
    );
  }
}
```

7. **Host Binding Directive**
```typescript
@Directive({
  selector: '[appHostBinding]'
})
export class HostBindingDirective {
  @HostBinding('style.backgroundColor') backgroundColor: string = 'transparent';
  
  @HostListener('mouseenter') onMouseEnter() {
    this.backgroundColor = 'lightgreen';
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.backgroundColor = 'transparent';
  }
}
```

8. **Structural vs Attribute Directive Comparison**
```typescript
// Structural Directive (Modifies DOM Structure)
@Directive({
  selector: '[appRemove]'
})
export class RemoveDirective {
  constructor(
    private templateRef: TemplateRef<any>,
    private viewContainer: ViewContainerRef
  ) {}

  @Input() set appRemove(condition: boolean) {
    if (condition) {
      this.viewContainer.clear();
    } else {
      this.viewContainer.createEmbeddedView(this.templateRef);
    }
  }
}

// Attribute Directive (Modifies Element Appearance/Behavior)
@Directive({
  selector: '[appChangeColor]'
})
export class ChangeColorDirective {
  @Input('appChangeColor') color: string = 'red';

  constructor(private el: ElementRef) {
    this.el.nativeElement.style.color = this.color;
  }
}
```

Key Points:
- **Structural Directives** modify DOM structure
- **Attribute Directives** modify element appearance/behavior
- Use `@Directive` decorator to create custom directives
- Leverage `@HostListener` for event handling
- Use `@HostBinding` to bind to host element properties

Common Use Cases:
- DOM manipulation
- Element styling
- Event handling
- Conditional rendering
- Performance optimization

Best Practices:
- Keep directives focused and single-responsibility
- Use `Renderer2` for DOM manipulations
- Prefer structural directives for DOM changes
- Use attribute directives for styling/behavior modifications

Would you like me to elaborate on any specific type of Angular directive or provide more detailed examples?